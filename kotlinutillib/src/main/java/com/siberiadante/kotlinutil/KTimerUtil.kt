package com.siberiadante.kotlinutil

/**
 * @CreateTime: 2018/1/29
 * @UpDateTime:2018/1/29
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 */
object KTimerUtil {
    var lastClickTime: Long = 0
    private val DEFAULT_CLICK_DELAY_TIME = 1000

    /**
     * 防止重复点击同一按钮
     * @param time：时间间隔（毫秒）
     */
    fun isNotFastClick(time: Int): Boolean {
        val currentTime = System.currentTimeMillis()
        val flag = ((currentTime - lastClickTime) >= time)
        lastClickTime = currentTime
        return flag
    }

    /**
     *  防止重复点击同一按钮
     */
    fun isNotFastClick(): Boolean {
        return isNotFastClick(DEFAULT_CLICK_DELAY_TIME)
    }
}