package com.hcp.hpd_android_mvvm_kotlin.mvvm_base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable

open class BaseCellViewModel : ViewModel {

    protected var compositeDisposable: CompositeDisposable

    constructor(compositeDisposable: CompositeDisposable) {
        this.compositeDisposable = compositeDisposable
    }
}