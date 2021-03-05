package com.hcp.hpd_android_mvvm_kotlin.mvvm_base

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.viewbinding.ViewBinding
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.ParameterizedType

open class BaseCell<T : ViewBinding> : FrameLayout {

    protected lateinit var binding: T
    open var compositeDisposable = CompositeDisposable()

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

    init {
        setup()
    }

    protected fun setup() {
        initLayout()
        initSetup()
        initBindView()
        initBindVM()
    }

    fun resetBind() {
        compositeDisposable.clear()
        compositeDisposable = CompositeDisposable()
        initSetup()
        initBindView()
        initBindVM()
    }

    private fun initLayout() {
        try {
            val type = javaClass.genericSuperclass as ParameterizedType
            val cls = type.actualTypeArguments[0] as Class<*>
            val inflate = cls.getDeclaredMethod(
                "inflate",
                LayoutInflater::class.java,
                ViewGroup::class.java,
                Boolean::class.java
            )
            binding = inflate.invoke(null, LayoutInflater.from(context), this, true) as T
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

    protected open fun initSetup() {}
    protected open fun initBindView() {}
    protected open fun initBindVM() {}
}
