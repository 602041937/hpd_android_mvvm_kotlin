package com.hcp.hpd_android_mvvm_kotlin.student.controllers

import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.hcp.hpd_android_mvvm_kotlin.databinding.ActivityStudentBinding
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseActivity
import com.hcp.hpd_android_mvvm_kotlin.mvvm_base.BaseAdapter
import com.hcp.hpd_android_mvvm_kotlin.router.Router
import com.hcp.hpd_android_mvvm_kotlin.student.viewmodels.StudentViewModel
import com.hcp.hpd_android_mvvm_kotlin.student.views.StudentCell

@Route(path = Router.Companion.studentMain)
class StudentActivity : BaseActivity<ActivityStudentBinding>() {

    lateinit var vm: StudentViewModel

    lateinit var adapter: StudentAdapter

    override fun initSetup() {
        super.initSetup()

        vm = ViewModelProvider.AndroidViewModelFactory(application)
            .create(StudentViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentAdapter()
        binding.recyclerView.adapter = adapter
    }

    override fun initBindVM() {
        super.initBindVM()

        vm.students.subscribe {
            adapter.notifyDataSetChanged()
        }
    }

    inner class StudentAdapter : BaseAdapter() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(StudentCell(parent.context))
        }

        override fun getItemCount(): Int {
            return vm.students.value.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val cell = holder.itemView as StudentCell
            cell.resetBind()
            val item = vm.students.value[position]
            cell.vm.setData(item)
        }
    }
}