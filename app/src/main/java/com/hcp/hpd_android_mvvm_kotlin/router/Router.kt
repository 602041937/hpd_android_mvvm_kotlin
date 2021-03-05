package com.hcp.hpd_android_mvvm_kotlin.router

import com.alibaba.android.arouter.launcher.ARouter

class Router {

    companion object {

        val shared = Router()

        const val studentMain = "/student/main"
        const val studentDetail = "/student/detail"
    }

    fun student() {
        ARouter.getInstance().build(studentMain).navigation()
    }

    fun studentDetail(studentId: Int) {
        ARouter.getInstance().build(studentDetail)
            .withInt("studentId", studentId)
            .navigation()
    }
}