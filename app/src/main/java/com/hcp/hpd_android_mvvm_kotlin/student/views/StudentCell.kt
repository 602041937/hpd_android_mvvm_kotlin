package com.hcp.hpd_android_mvvm_kotlin.student.views

import android.content.Context
import android.util.AttributeSet
import com.hcp.hpd_android_mvvm_kotlin.databinding.StudentCellBinding
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseCell
import com.hcp.hpd_android_mvvm_kotlin.student.viewmodels.StudentCellViewModel
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.plusAssign

class StudentCell : BaseCell<StudentCellBinding> {

    lateinit var vm: StudentCellViewModel

    constructor(context: Context) : super(context) {}
    constructor(
        context: Context,
        attrs: AttributeSet?
    ) : super(context, attrs) {
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
    }

    override fun initSetup() {
        super.initSetup()
        vm = StudentCellViewModel(compositeDisposable)
    }

    override fun initBindView() {
        super.initBindView()

        binding.root.clicks().subscribe {
            vm.dealClick()
        }.addTo(compositeDisposable)

        binding.btnClick.clicks().subscribe {
            vm.name.onNext(vm.name.value + vm.name.value)
        }.addTo(compositeDisposable)
    }

    override fun initBindVM() {
        super.initBindVM()

        vm.name.subscribe { it ->
            binding.tvUsername.text = it
        }.addTo(compositeDisposable)

        vm.age.subscribe { it ->
            binding.tvAge.text = it
        }.addTo(compositeDisposable)
    }
}