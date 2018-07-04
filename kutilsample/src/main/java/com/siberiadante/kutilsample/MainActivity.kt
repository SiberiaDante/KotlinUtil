package com.siberiadante.kutilsample

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.siberiadante.kotlinutil.KActivityMangerUtil
import com.siberiadante.kutilsample.adapter.MainAdapter
import com.siberiadante.kutilsample.model.UtilModel
import com.siberiadante.kutilsample.ui.SDDateUtilsActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

/**
 * https://kotlintc.com/articles/3532
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val tag = MainActivity::class.java.simpleName.toString()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        initView()
    }

    private fun initView() {
        KActivityMangerUtil.addActivity(this)
        Log.i(tag, "----------------------------------")
        var datas = ArrayList<UtilModel<*>>()
        getDataContent(datas)
        rv_main.layoutManager = GridLayoutManager(this, 2)
        rv_main.adapter = MainAdapter(this, datas, {
            val intent = Intent()
            intent.setClass(this, it.cls as Class<*>?)
            startActivity(intent)
        })
    }

    private fun getDataContent(datas: ArrayList<UtilModel<*>>) {
        datas.add(UtilModel("KDateUtil", SDDateUtilsActivity::class.java))
        datas.add(UtilModel("SDLogUtil", SDDateUtilsActivity::class.java))
        datas.add(UtilModel("SDNetWorkUtil", SDDateUtilsActivity::class.java))
        datas.add(UtilModel("SDTimerUtil", SDDateUtilsActivity::class.java))
        datas.add(UtilModel("KTransitionUtil", SDDateUtilsActivity::class.java))
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
