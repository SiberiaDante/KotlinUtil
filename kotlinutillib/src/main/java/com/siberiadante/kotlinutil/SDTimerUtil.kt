package com.siberiadante.kotlinutil

/**
 * @Created  SiberiaDante
 * @Describe：
 * @CreateTime: 2018/2/6
 * @UpDateTime:
 * @Email: 2654828081@qq.com
 * @GitHub: https://github.com/SiberiaDante
 * @Blogs: http://www.cnblogs.com/shen-hua/
 */
object SDTimerUtil {
    var lastClickTime: Long = 0
    private val DEFAULT_CLICK_DELAY_TIME = 1000

    /**
     * 防止重复点击同一按钮
     */
    fun isNotFastClick(): Boolean {
        val currentTime = System.currentTimeMillis()
        val flag = ((currentTime - lastClickTime) >= DEFAULT_CLICK_DELAY_TIME)
        lastClickTime = currentTime
        return flag
    }
}