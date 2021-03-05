package com.hcp.hpd_android_mvvm_kotlin.mvvm_base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.alibaba.android.arouter.launcher.ARouter
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.lang.Exception
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

open class BaseFragment<T : ViewBinding> : Fragment() {

    protected lateinit var binding: T

    protected val compositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        try {
            val genericSuperclass = javaClass.genericSuperclass as ParameterizedType
            val cls = genericSuperclass.actualTypeArguments[0] as Class<*>
            val inflate =
                cls.getDeclaredMethod(
                    "inflate",
                    LayoutInflater::class.java,
                    ViewGroup::class.java,
                    Boolean::class.java
                )
            binding = inflate.invoke(null, layoutInflater, container, false) as T
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ARouter.getInstance().inject(this)

        initSetup()
        initBindView()
        initBindVM()
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