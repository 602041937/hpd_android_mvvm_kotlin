package com.hcp.hpd_android_mvvm_kotlin.student_detail.viewmodels

import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseViewModel
import io.reactivex.rxjava3.subjects.BehaviorSubject

class StudentDetailViewModel : BaseViewModel() {

    val title = BehaviorSubject.createDefault("")

    private var studentId: Int? = null

    fun setData(studentId: Int) {

        this.studentId = studentId
        title.onNext("学生id: $studentId")
    }
}