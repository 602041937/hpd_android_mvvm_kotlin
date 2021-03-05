package com.hcp.hpd_android_mvvm_kotlin.student_detail.controllers

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.hcp.hpd_android_mvvm_kotlin.R
import com.hcp.hpd_android_mvvm_kotlin.databinding.ActivityStudentDetailBinding
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseActivity
import com.hcp.hpd_android_mvvm_kotlin.router.Router
import com.hcp.hpd_android_mvvm_kotlin.student_detail.viewmodels.StudentDetailViewModel
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.plusAssign

@Route(path = Router.studentDetail)
class StudentDetailActivity : BaseActivity<ActivityStudentDetailBinding>() {

    @JvmField
    @Autowired
    var studentId: Int = 0

    private lateinit var vm: StudentDetailViewModel

    private lateinit var studentInfoFragment: StudentInfoFragment

    override fun initSetup() {
        super.initSetup()

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
            .create(StudentDetailViewModel::class.java)
        vm.setData(studentId)

        val beginTransaction = supportFragmentManager.beginTransaction()
        studentInfoFragment = StudentInfoFragment.newInstance()
        beginTransaction.add(R.id.flInfoFragment, studentInfoFragment)
        beginTransaction.commit()
    }

    override fun initBindView() {
        super.initBindView()
    }

    override fun initBindVM() {
        super.initBindVM()

        vm.title.subscribe {
            binding.tvId.text = it
        }.addTo(compositeDisposable)
    }
}