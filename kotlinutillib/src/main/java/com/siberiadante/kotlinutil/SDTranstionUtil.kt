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
class SDTranstionUtil {
    /**
     * dip to  px
     */
    fun dip2px(context: Context, dipValue: Float): Float {
        var density = context.resources.displayMetrics.density
        return density * dipValue + 0.5f
    }

    /**
     * px to dip
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }
}