package com.hcp.hpd_android_mvvm_kotlin.mvvm_base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import com.hcp.hpd_android_mvvm_kotlin.student.entities.StudentBean
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.lang.Exception
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

open class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: T

    protected val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)

        initLayout()
        initSetup()
        initBindView()
        initBindVM()
    }

    private fun initLayout() {
        try {
            val genericSuperclass = javaClass.genericSuperclass as ParameterizedType
            val cls = genericSuperclass.actualTypeArguments[0] as Class<*>
            val inflate = cls.getDeclaredMethod("inflate", LayoutInflater::class.java)
            binding = inflate.invoke(null, layoutInflater) as T
            setContentView(binding.root)
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    open fun initSetup() {

    }

    open fun initBindView() {

    }

    open fun initBindVM() {

    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}