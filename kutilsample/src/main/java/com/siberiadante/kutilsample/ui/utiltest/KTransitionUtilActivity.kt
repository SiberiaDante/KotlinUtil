package com.siberiadante.kutilsample.ui.utiltest

import com.siberiadante.kotlinutil.KTransitionUtil
import com.siberiadante.kutilsample.R
import com.siberiadante.kutilsample.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_ktransition_util.*

class KTransitionUtilActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_ktransition_util
    }

    override fun initView() {
        supportActionBar?.title = getString(R.string.title_transition_util)
    }

    override fun initData() {
        var result = StringBuilder()
        result.append("屏幕密度：" + KTransitionUtil.getDensity(this) + "\n")
        result.append("10dip = " + KTransitionUtil.dip2px(this, (10).toFloat()) + "px\n")
        result.append("10px = " + KTransitionUtil.px2dip(this, (10).toFloat()) + "dip\n")
        result.append("10sp = " + KTransitionUtil.sp2px(this, (10).toFloat()) + "px\n")
        result.append("10px = " + KTransitionUtil.px2sp(this, (10).toFloat()) + "sp\n")

        tv_content.text = result.toString()
    }
}
