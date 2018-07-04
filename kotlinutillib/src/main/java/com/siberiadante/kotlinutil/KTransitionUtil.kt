package com.siberiadante.kotlinutil

import android.content.Context

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/1/29
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
object KTransitionUtil {

    /**
     * dip transition to  px
     */
    fun dip2px(context: Context, dipValue: Float): Float {
        val density = context.resources.displayMetrics.density
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