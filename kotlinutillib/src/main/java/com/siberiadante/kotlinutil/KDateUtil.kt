package com.siberiadante.kotlinutil

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/**
 * @CreateTime: 2018/2/6
 * @UpDateTime:2018/2/6
 * @CreateBy:SiberiaDante
 * @Email:2654828081@qq.com
 * @Github:https://github.com/SiberiaDante
 * @Blog:http://www.cnblogs.com/shen-hua/
 * @Describe:
 * 格式转换参考
 * HH:mm                                                15:44
 * h:mm a                                               3:44 下午
 * HH:mm z                                              15:44 CST
 * HH:mm Z                                              15:44 +0800
 * HH:mm zzzz                                           15:44 中国标准时间
 * HH:mm:ss                                             15:44:40
 * yyyy-MM-dd                                           2016-08-12
 * yyyy-MM-dd HH:mm                                     2016-08-12 15:44
 * yyyy-MM-dd HH:mm:ss                                  2016-08-12 15:44:40
 * yyyy-MM-dd HH:mm:ss zzzz                             2016-08-12 15:44:40 中国标准时间
 * EEEE yyyy-MM-dd HH:mm:ss zzzz                        星期五 2016-08-12 15:44:40 中国标准时间
 * yyyy-MM-dd HH:mm:ss.SSSZ                             2016-08-12 15:44:40.461+0800
 * yyyy-MM-dd'T'HH:mm:ss.SSSZ                           2016-08-12T15:44:40.461+0800
 * yyyy.MM.dd G 'at' HH:mm:ss z                         2016.08.12 公元 at 15:44:40 CST
 * K:mm a                                               3:44 下午
 * EEE, MMM d, ''yy                                     星期五, 八月 12, '16
 * hh 'o''clock' a, zzzz                                03 o'clock 下午, 中国标准时间
 * yyyyy.MMMMM.dd GGG hh:mm aaa                         02016.八月.12 公元 03:44 下午
 * EEE, d MMM yyyy HH:mm:ss Z                           星期五, 12 八月 2016 15:44:40 +0800
 * yyMMddHHmmssZ                                        160812154440+0800
 * yyyy-MM-dd'T'HH:mm:ss.SSSZ                           2016-08-12T15:44:40.461+0800
 * EEEE 'DATE('yyyy-MM-dd')' 'TIME('HH:mm:ss')' zzzz    星期五 DATE(2016-08-12) TIME(15:44:40) 中国标准时间
 */
object KDateUtil {
    private const val DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss"

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

    /**
     * get current year
     */
    fun getCurrentYear(): String {
        return getCurrentYear(getTimeStamp())
    }

    /**
     * get current year
     * @param timestamp:seconds
     */
    fun getCurrentYear(timestamp: Long): String {
        return SimpleDateFormat("yyyy", Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get current month
     */
    fun getCurrentMonth(): String {
        return getCurrentMonth(getTimeStamp())
    }

    /**
     * get current month
     * @param timestamp:seconds time
     */
    fun getCurrentMonth(timestamp: Long): String {
        return SimpleDateFormat("MM", Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get current day
     */
    fun getCurrentDay(): String {
        return getCurrentDay(getTimeStamp())
    }

    /**
     * get current day
     * @param timestamp:seconds
     */
    fun getCurrentDay(timestamp: Long): String {
        return SimpleDateFormat("dd", Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get current hours
     */
    fun getCurrentHours(): String {
        return getCurrentHours(getTimeStamp())
    }

    /**
     * get current hours
     * @param timestamp:seconds
     */
    fun getCurrentHours(timestamp: Long): String {
        return SimpleDateFormat("HH", Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get current minutes
     */
    fun getCurrentMinutes(): String {
        return getCurrentMinutes(getTimeStamp())
    }

    /**
     * get current minutes
     * @param timestamp:seconds
     */
    fun getCurrentMinutes(timestamp: Long): String {
        return SimpleDateFormat("mm", Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get current seconds
     */
    fun getCurrentSeconds(): String {
        return getCurrentSeconds(getTimeStamp())
    }

    /**
     * get current seconds
     * @param timestamp:seconds
     */
    fun getCurrentSeconds(timestamp: Long): String {
        return SimpleDateFormat("ss", Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get current date and time
     */
    fun getDateTime(): String {
        return SimpleDateFormat(DEFAULT_PATTERN, Locale.CHINA).format(Date(getTimeStampMillis()))
    }

    /**
     * get current date based on {@param format}
     *@param format time or date format
     */
    fun getDateTime(format: String): String {
        return SimpleDateFormat(format, Locale.CHINA).format(Date(getTimeStampMillis()))
    }

    /**
     * timestamp transform to date and time
     * @param timestamp:seconds
     * @param format :date or time format
     */
    fun getTimeStampToDate(timestamp: Long, format: String): String {
        return SimpleDateFormat(format, Locale.CHINA).format(Date(timestamp * 1000))
    }

    /**
     * get total days of some month
     * @param year
     * @param month
     */
    fun getTotalDaysOfMonth(year: Int, month: Int): Int {
        var day = 0
        day = if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            29
        } else {
            28
        }
        when (month) {
            1, 3, 5, 7, 8, 10, 12 ->
                return 31
            4, 6, 9, 11 ->
                return 30
            2 ->
                return day
        }
        return 0
    }

    fun getConstellation(month: Int, day: Int): String {
        val starArr = listOf("魔羯座", "水瓶座", "双鱼座", "牡羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座")
        val dayArr = listOf(22, 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22)
        if (month > 12 || month < 1 || day > 31 || day < 1) {
            return "猴年马月座"
        }
        var index: Int = month
        if (day < dayArr[month - 1]) {
            index -= 1
        }
        return starArr[index]
    }
}