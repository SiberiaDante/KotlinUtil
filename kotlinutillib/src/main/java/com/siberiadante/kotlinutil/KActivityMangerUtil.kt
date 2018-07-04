package com.siberiadante.kotlinutil

import android.app.ActivityManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.*

/**
 * CreateTime: 2018/7/4
 * UpDateTime:
 * Describe:
 */
object KActivityMangerUtil {
    private val TAG = KActivityMangerUtil::class.java.simpleName.toString()
    //the stack of save AppCompatActivity
    private val activityStack: Stack<AppCompatActivity> = Stack()

    /**
     * add activity
     */
    fun addActivity(activity: AppCompatActivity) {
        activityStack.add(activity)
        Log.i(TAG, "------add ${activity::class.java} ------activity size--------${activityStack.size}")
    }

    /**
     * remove activity
     */
    fun removeActivit(activity: AppCompatActivity) {
        if (activityStack.contains(activity)) {
            activityStack.remove(activity)
            Log.i(TAG, "------remove ${activity::class.java} ------activity size--------${activityStack.size}")
        }
    }

    /**
     * get the stack top activity
     */
    fun getTopActivity(): AppCompatActivity {
        Log.i(TAG, "------getTopActivity ${activityStack.peek()::class.java} ------activity size--------${activityStack.size}")
        return activityStack.peek()
    }

    /**
     * finish designated activity
     */
    fun finishActivity(activity: AppCompatActivity) {
        if (activityStack.contains(activity)) {
            activityStack.remove(activity)
            activity.finish()
            Log.i(TAG, "------finished ${activity::class.java} ------activity size--------${activityStack.size}")
        }
    }

    /**
     * finish all Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
            Log.i(TAG, "------finished ${activity::class.java} ------activity size--------${activityStack.size}")
        }
        activityStack.clear()
    }

    /**
     *exit app
     * need permission:{@code:<uses-permission android:name="android.permission.KILL_BACKGROUND_PROCESSES" />}
     */
    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)


    }
}