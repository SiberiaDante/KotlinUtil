package com.siberiadante.kotlinutil

import android.app.Application
import android.content.Context


/**
 * @CreateTime: 2018/1/29
 * @UpDateTime:2018/1/29
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 */
class KotlinUtil {
    companion object {
        private var instance: Application? = null
        fun init(context: Application) {
            instance = context
        }

        fun getContext() = instance!!
    }


}