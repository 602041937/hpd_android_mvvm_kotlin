package com.hcp.hpd_android_mvvm_kotlin

import com.hcp.hpd_android_mvvm_kotlin.databinding.ActivityMainBinding
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseActivity
import com.hcp.hpd_android_mvvm_kotlin.router.Router
import com.jakewharton.rxbinding4.view.clicks

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initSetup() {
        super.initSetup()

    }

    override fun initBindView() {
        super.initBindView()

        binding.enterBtn.clicks().subscribe {
            Router.shared.student()
        }
    }
}