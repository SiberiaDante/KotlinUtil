package com.siberiadante.kutilsample.ui.utiltest

import android.Manifest
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.siberiadante.kotlinutil.KDeviceUtil
import com.siberiadante.kutilsample.R
import com.siberiadante.kutilsample.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_kdevice_util.*

class KDeviceUtilActivity : BaseActivity() {
    val TAG = KDeviceUtilActivity::class.java.simpleName
    private val result = StringBuilder()

    override fun getLayoutId(): Int {
        return R.layout.activity_kdevice_util;
    }

    override fun initView() {
        supportActionBar?.title = getString(R.string.title_device_util)
    }

    override fun initData() {
        result.append("Android 设备系统版本名：" + KDeviceUtil.getSDKVersionName() + "\n")
        result.append("Android 设备系统版本号：" + KDeviceUtil.getSDKVersionCode() + "\n")
        result.append("Android 系统版本名：" + KDeviceUtil.getDeviceSystemVersionName() + "\n")
        result.append("Android 设备类型：" + KDeviceUtil.getDeviceType() + "\n")
        result.append("Android 设备型号：" + KDeviceUtil.getDeviceModel() + "\n")
        result.append("Android 设备名：" + KDeviceUtil.getDeviceName() + "\n")
        result.append("Android 设备厂商：" + KDeviceUtil.getDeviceBuild() + "\n")
        result.append("Android 设备是否root：" + KDeviceUtil.isDeviceRooted() + "\n")
        result.append("Android 设备SIM卡是否准备好：" + KDeviceUtil.isSIMCardReady() + "\n")
        result.append("Android 设备SIM卡运营商名：" + KDeviceUtil.getSIMCardOperatorName() + "\n")
        result.append("Android 设备SIM卡运营商名：" + KDeviceUtil.getSIMCardOperatorNameCN() + "\n")
        result.append("Android 设备SIM卡运营商码：" + KDeviceUtil.getSIMCardOperatorCode() + "\n")
        result.append("Android 设备Id：" + KDeviceUtil.getAndroidId() + "\n")
        tv_content.text = result


//        result.append("获取手机号码：" + KDeviceUtil.getDeviceMobileNumber() + "\n")
        tv_get_number.setOnClickListener { v -> checkNumberPermission() }
        tv_get_contacts.setOnClickListener { v -> checkContactPermission() }

    }

    private fun checkNumberPermission() {
        val permission = arrayOf(Manifest.permission.READ_PHONE_STATE)
        val readContactsPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE)
        if (readContactsPermission == PackageManager.PERMISSION_GRANTED) {
            getContactsInfo()
        } else {
            ActivityCompat.requestPermissions(this, permission, 0x02)
        }
    }

    private fun checkContactPermission() {
        val permission = arrayOf(Manifest.permission.READ_CONTACTS, Manifest.permission.WRITE_CONTACTS)
        val readContactsPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)
        if (readContactsPermission == PackageManager.PERMISSION_GRANTED) {
            getContactsInfo()
        } else {
            ActivityCompat.requestPermissions(this, permission, 0x01)
        }

    }

    private fun getContactsInfo() {
        result.append("<<<<读取设备联系人信息>>>>：\n")
        for (contact: HashMap<String, String> in KDeviceUtil.getContactsList()) {
            result.append("姓名：" + contact["name"] + "---电话：" + contact["number"] + "\n")
        }
        tv_content.text = result
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 0x01) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                getContactsInfo()
            }
        }
        if (requestCode == 0x02) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                result.append("获取手机号码：" + KDeviceUtil.getDeviceMobileNumber() + "\n")
                tv_content.text = result
            }
        }
    }

}
