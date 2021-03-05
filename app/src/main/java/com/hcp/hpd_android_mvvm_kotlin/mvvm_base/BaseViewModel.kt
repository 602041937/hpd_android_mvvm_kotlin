package com.hcp.hpd_android_mvvm_kotlin.mvvm_base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject

open class BaseViewModel : ViewModel() {

    protected val compositeDisposable = CompositeDisposable()

    public val finish = PublishSubject.create<Unit>()

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.clear()
    }
}
