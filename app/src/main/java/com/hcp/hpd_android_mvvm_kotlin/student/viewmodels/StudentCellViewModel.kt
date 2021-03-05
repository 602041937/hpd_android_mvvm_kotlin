package com.hcp.hpd_android_mvvm_kotlin.student.viewmodels

import android.util.Log
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseCellViewModel
import com.hcp.hpd_android_mvvm_kotlin.router.Router
import com.hcp.hpd_android_mvvm_kotlin.student.entities.StudentBean
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject

class StudentCellViewModel(compositeDisposable: CompositeDisposable) :
    BaseCellViewModel(compositeDisposable) {

    var studentBean: StudentBean? = null

    val name = BehaviorSubject.createDefault("1")
    val age = BehaviorSubject.createDefault("1")

    fun setData(bean: StudentBean) {

        this.studentBean = bean

        name.onNext(bean.name)
        age.onNext(bean.age)
    }

    fun dealClick() {
        studentBean?.let {
            Router.shared.studentDetail(it.id ?: 0)
        }
    }
}