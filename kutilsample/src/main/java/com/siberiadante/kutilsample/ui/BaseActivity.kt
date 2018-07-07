package com.siberiadante.kutilsample.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * CreateTime: 2018/7/6
 * UpDateTime:
 * Describe:
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        beforeSetContentView()
        setContentView(getLayoutId())
        initView()
        initData()
    }

    private fun beforeSetContentView() {

    }

    abstract fun getLayoutId(): Int

    protected abstract fun initView()
    protected abstract fun initData()
}