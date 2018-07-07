package com.siberiadante.kotlinutil

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics


/**
 * @CreateTime: 2018/1/29
 * @UpDateTime:2018/1/29
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 */
object KTransitionUtil {

    /**
     * get screen density
     */
    fun getDensity(activity: AppCompatActivity): Float {
        var displayMetrics = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(displayMetrics)
        return displayMetrics.density
    }

    /**
     * dip transition to  px
     */
    fun dip2px(context: Context, dipValue: Float): Float {
        val density = KotlinUtil.getContext().resources.displayMetrics.density
        return density * dipValue + 0.5f
    }

    /**
     * px transition to dip
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * sp transition to px
     */
    fun sp2px(context: Context, pxValue: Float): Float {
        var scaledDensity = context.resources.displayMetrics.scaledDensity
        return scaledDensity * pxValue + 0.5f
    }

    /**
     * px transition to sp
     */
    fun px2sp(context: Context, spValue: Float): Int {
        var scaledDensity = context.resources.displayMetrics.scaledDensity
        return (spValue / scaledDensity + 0.5f).toInt()
    }
}