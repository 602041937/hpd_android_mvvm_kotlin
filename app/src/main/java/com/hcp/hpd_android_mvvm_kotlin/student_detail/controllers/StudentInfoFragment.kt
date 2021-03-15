package com.hcp.hpd_android_mvvm_kotlin.student_detail.controllers

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.hcp.hpd_android_mvvm_kotlin.databinding.FragmentStudentInfoBinding
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseFragment
import com.hcp.hpd_android_mvvm_kotlin.student_detail.viewmodels.StudentInfoViewModel
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.kotlin.addTo

/**
 * A simple [Fragment] subclass.
 * Use the [StudentInfoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Route(path = "/student/infoFragment")
class StudentInfoFragment : BaseFragment<FragmentStudentInfoBinding>() {

    private lateinit var vm: StudentInfoViewModel

    @JvmField
    @Autowired
    var studentId: Int = 0

    companion object {
        fun newInstance(studentId: Int): StudentInfoFragment {
            return ARouter.getInstance()
                .build("/student/infoFragment")
                .withInt("studentId", studentId)
                .navigation() as StudentInfoFragment
        }
    }

    override fun initSetup() {
        super.initSetup()

        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(activity!!.application)
            .create(StudentInfoViewModel::class.java);

        vm.setData(studentId)
    }

    override fun initBindView() {
        super.initBindView()

        binding.btnQuite.clicks().subscribe {
            activity?.finish()
        }.addTo(compositeDisposable)
    }

    override fun initBindVM() {
        super.initBindVM()

        vm.info.subscribe { binding.tvInfo.text = it }.addTo(compositeDisposable)
    }
}