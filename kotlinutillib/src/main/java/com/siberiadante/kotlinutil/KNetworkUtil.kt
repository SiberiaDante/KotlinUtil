package com.siberiadante.kotlinutil

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/29
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
object KNetworkUtil {
    /**
     * udge network is connection
     * need permission{@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}
     */
    @SuppressLint("MissingPermission")
    fun isNetConneted(context: Context): Boolean {
        val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo? = connectManager.activeNetworkInfo
        if (networkInfo == null) {
            return false
        } else {
            return networkInfo.isAvailable && networkInfo.isConnected
        }

    }

    /**
     * judge network is connection
     * need permission{@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}
     */
    @SuppressLint("MissingPermission")
    fun isNetConnected(context: Context, typeMobile: Int): Boolean {
        if (!isNetConneted(context)) {
            return false
        }
        val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo: NetworkInfo = connectManager.getNetworkInfo(typeMobile)
        if (networkInfo == null) {
            return false
        } else {
            return networkInfo.isConnected && networkInfo.isAvailable
        }
    }

    /**
     * mobile network connection
     */
    fun isPhoneNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_MOBILE
        return isNetConnected(context, typeMobile)
    }

    /**
     * wifi network connection
     */
    fun isWifiNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_WIFI
        return isNetConnected(context, typeMobile)
    }
}