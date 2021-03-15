package com.hcp.hpd_android_mvvm_kotlin.student_detail.viewmodels

import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseViewModel
import io.reactivex.rxjava3.subjects.BehaviorSubject

class StudentInfoViewModel : BaseViewModel() {

    val info = BehaviorSubject.createDefault("")

    fun setData(studentId: Int) {

        info.onNext("学生的info： id=$studentId")
    }
}