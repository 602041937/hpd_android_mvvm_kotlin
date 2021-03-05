package com.hcp.hpd_android_mvvm_kotlin

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}