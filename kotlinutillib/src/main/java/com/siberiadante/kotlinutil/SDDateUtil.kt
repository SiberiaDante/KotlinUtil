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
object SDDateUtil {

    /**
     * 获取时间戳
     */
    fun getTimeStamp(): Long {
        return System.currentTimeMillis() / 1000
    }

}