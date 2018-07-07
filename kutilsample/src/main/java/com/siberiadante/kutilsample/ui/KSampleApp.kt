package com.siberiadante.kutilsample.ui

import android.app.Application
import com.siberiadante.kotlinutil.KotlinUtil
import com.squareup.leakcanary.LeakCanary

/**
 * @CreateTime: 2018/7/7
 * @UpDateTime:2018/7/7
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 */
class KSampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        KotlinUtil.init(this)
        LeakCanary.install(this)
    }
}