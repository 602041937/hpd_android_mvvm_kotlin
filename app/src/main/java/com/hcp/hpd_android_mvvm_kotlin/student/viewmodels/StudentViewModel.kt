package com.hcp.hpd_android_mvvm_kotlin.student.viewmodels

import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseViewModel
import com.hcp.hpd_android_mvvm_kotlin.student.entities.StudentBean
import io.reactivex.rxjava3.subjects.BehaviorSubject

class StudentViewModel : BaseViewModel() {

    val students = BehaviorSubject.createDefault(ArrayList<StudentBean>())

    init {
        var temp = ArrayList<StudentBean>()
        for (i in 0..100) {
            val item = StudentBean()
            item.id = i
            item.age = "age$i"
            item.name = "name$i"
            temp.add(item)
        }
        students.onNext(temp)
    }
}