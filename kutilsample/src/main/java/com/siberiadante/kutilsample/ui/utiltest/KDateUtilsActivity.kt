package com.siberiadante.kutilsample.ui.utiltest

import com.siberiadante.kotlinutil.KDateUtil
import com.siberiadante.kutilsample.R
import com.siberiadante.kutilsample.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_kdate_utils.*

class KDateUtilsActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_kdate_utils
    }

    override fun initView() {
        supportActionBar?.title = getString(R.string.title_date_util)
    }

    override fun initData() {
        val result = StringBuilder()
        result.append("当前时间戳（秒）：" + KDateUtil.getTimeStamp() + "\n")
        result.append("当前时间戳（毫秒）：" + KDateUtil.getTimeStampMillis() + "\n")
        result.append("当前年：" + KDateUtil.getCurrentYear() + "年\n")
        result.append("当前月：" + KDateUtil.getCurrentMonth() + "月\n")
        result.append("当前日：" + KDateUtil.getCurrentDay() + "日\n")
        result.append("当前时：" + KDateUtil.getCurrentHours() + "时\n")
        result.append("当前分：" + KDateUtil.getCurrentMinutes() + "分\n")
        result.append("当前秒：" + KDateUtil.getCurrentSeconds() + "秒\n")
        result.append("当前日期时间：" + KDateUtil.getDateTime() + "\n")
        result.append("当前日期（指定格式：yyyy-MM-dd）：" + KDateUtil.getDateTime("yyyy-MM-dd") + "\n")
        result.append("时间戳（1530864798）转日期时间：" + KDateUtil.getTimeStampToDate(1530864798,"yyyy-MM-dd") + "\n")
        result.append(KDateUtil.getCurrentYear()+"年"+KDateUtil.getCurrentMonth()+"月总共有：" + KDateUtil.getTotalDaysOfMonth(KDateUtil.getCurrentYear().toInt(),KDateUtil.getCurrentMonth().toInt()) + "天\n")
        result.append("9月16日生的星座是：" + KDateUtil.getConstellation(9,16) + "\n")
        tv_content.text = result
    }

}
