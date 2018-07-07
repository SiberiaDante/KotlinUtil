package com.siberiadante.kotlinutil

import android.Manifest.permission.*
import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.net.wifi.WifiManager
import android.os.Build
import android.provider.Settings
import android.support.annotation.RequiresPermission
import android.telephony.TelephonyManager
import java.io.File

/**
 * @CreateTime: 2018/7/6
 * @UpDateTime:2018/7/6
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 */
object KDeviceUtil {

    private const val DEFAULT_MAC_ADDRESS = "02:00:00:00:00:00"
    /**
     * return android device system version name
     */
    fun getSDKVersionName(): String = android.os.Build.VERSION.RELEASE

    /**
     * return android device system version code
     */
    fun getSDKVersionCode(): Int = android.os.Build.VERSION.SDK_INT

    /**
     * return device system version name
     */
    fun getDeviceSystemVersionName(): String = KotlinUtil.getContext().packageManager.getPackageInfo(KotlinUtil.getContext().packageName, 0).versionName

    /**
     * return device type
     */
    fun getDeviceType(): String = android.os.Build.TYPE

    /**
     * return device model
     */
    fun getDeviceModel(): String = android.os.Build.MODEL

    /**
     * return device name and type
     */
    fun getDeviceName(): String = android.os.Build.DEVICE

    /**
     * return device build manufacture
     */
    fun getDeviceBuild(): String = android.os.Build.MANUFACTURER


    /**
     * judge device sim card is getting ready
     */
    fun isSIMCardReady(): Boolean {
        val telephonyManager = KotlinUtil.getContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.simState == TelephonyManager.SIM_STATE_READY
    }

    /**
     * need permission<uses-permission android:name="android.permission.READ_PHONE_STATE" />
     */
    @SuppressLint("SupportAnnotationUsage")
    @RequiresPermission(allOf = [READ_PHONE_STATE, READ_PHONE_NUMBERS, READ_SMS])
    fun getDeviceMobileNumber(): String? {
        val telephonyManager = KotlinUtil.getContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.line1Number
    }

    /**
     * get SIM card operator code
     */
    fun getSIMCardOperatorCode(): String {
        val telephonyManager = KotlinUtil.getContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.simOperator
    }

    /**
     * get SIM card operator name，CMCC...
     */
    fun getSIMCardOperatorName(): String {
        val telephonyManager = KotlinUtil.getContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.simOperatorName
    }

    /**
     * get SIM card operator name
     */
    fun getSIMCardOperatorNameCN(): String {
        val telephonyManager = KotlinUtil.getContext().getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        val operation = telephonyManager.simOperator
//        if (operation == null) return null
        return when (operation) {
            "46007", "46002", "46000" -> "中国移动"
            "46001" -> "中国联通"
            "46003" -> "中国电信"
            else -> operation
        }
    }

    /**
     * get device contacts list
     * need permission
     *  <uses-permission android:name="android.permission.WRITE_CONTACTS"/>
     *  <uses-permission android:name="android.permission.READ_CONTACTS"/>
     */
    @SuppressLint("SupportAnnotationUsage")
    @RequiresPermission(allOf = [READ_CONTACTS, WRITE_CONTACTS])
    fun getContactsList(): List<HashMap<String, String>> {
        val list = arrayListOf<HashMap<String, String>>()
        val contentResolver = KotlinUtil.getContext().contentResolver
        val rawUri = Uri.parse("content://com.android.contacts/raw_contacts")
        val dataUri = Uri.parse("content://com.android.contacts/data")
        val cursor = contentResolver.query(rawUri, arrayOf("contact_id"), null, null, null)
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val contactId: String? = cursor.getString(0)
                if (contactId != null) {
                    if (!contactId.isEmpty()) {
                        val cursor1 = contentResolver.query(dataUri, arrayOf("data1", "mimetype"), "raw_contact_id=?", arrayOf(contactId), null)
                        val hashMap = HashMap<String, String>()
                        if (cursor1 != null) {
                            while (cursor1.moveToNext()) {
                                val data1 = cursor1.getString(0)
                                val mimetype = cursor1.getString(1)
                                if (mimetype == "vnd.android.cursor.item/phone_v2") {
                                    hashMap["number"] = data1
                                } else if (mimetype == "vnd.android.cursor.item/name") {
                                    hashMap["name"] = data1
                                }
                            }
                        }
                        list.add(hashMap)
                        cursor1.close()
                    }
                }
            }
            cursor.close()
        }
        return list
    }

    /**
     * judge device where root
     */
    fun isDeviceRooted(): Boolean {
        val su = "su"
        val locations = listOf("/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/",
                "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/")
        for (location: String in locations) {
            if (File(location + su).exists()) {
                return true
            }
        }
        return false
    }

    @SuppressLint("HardwareIds")
    fun getAndroidId(): String {
        val id = Settings.Secure.getString(KotlinUtil.getContext().contentResolver, Settings.Secure.ANDROID_ID)
        return id ?: ""
    }

//    fun getMacAddress(): String {
//        var macAddress = getMacAddressByWifiInfo()
//        if (macAddress != DEFAULT_MAC_ADDRESS) {
//            return macAddress
//        }
//        return DEFAULT_MAC_ADDRESS
//    }
//
//    @SuppressLint("SupportAnnotationUsage", "HardwareIds", "MissingPermission")
//    @RequiresPermission(allOf = [ACCESS_WIFI_STATE])
//    private fun getMacAddressByWifiInfo(): String {
//        val wifiManager = KotlinUtil.getContext().applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
//        return wifiManager.connectionInfo.macAddress
//    }


}