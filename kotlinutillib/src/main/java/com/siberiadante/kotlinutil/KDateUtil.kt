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
object KDateUtil {

    /**
     * get time stamp
     */
    fun getTimeStamp(): Long {
        return getTimeStampMillis() / 1000
    }

    /**
     * get time stamp in milliseconds
     */
    fun getTimeStampMillis(): Long {
        return System.currentTimeMillis()
    }
}