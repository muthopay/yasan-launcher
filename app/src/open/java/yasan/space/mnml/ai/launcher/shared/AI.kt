package yasan.space.mnml.ai.launcher.shared

import android.content.Context
import android.util.Log
import yasan.space.mnml.ai.launcher.data.app.App

object AI { // Dummy AI object

    private const val TAG = "AI"

    fun recordAppLaunch(app: App, context: Context) {
        Log.d(TAG, "recordAppLaunch: ")
    }

    fun getAppScore(app: App, context: Context): Int = 0

}