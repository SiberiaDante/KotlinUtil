package com.siberiadante.kotlinutil

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
class SDNetworkUtil {
    /**
     * 网络是否连接
     * 需要权限{@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}
     */
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
     * 网络是否连接
     * 需要权限{@code <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>}
     */
    fun isNetworkConnected(context: Context, typeMobile: Int): Boolean {
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
     * 是否手机网络连接
     */
    fun isPhoneNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_MOBILE
        return isNetworkConnected(context, typeMobile)
    }

    /**
     * 是否无线网络连接
     */
    fun isWifiNetConnected(context: Context): Boolean {
        val typeMobile = ConnectivityManager.TYPE_WIFI
        return isNetworkConnected(context, typeMobile)
    }
}