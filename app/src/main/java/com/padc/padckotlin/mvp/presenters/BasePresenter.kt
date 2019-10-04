package com.padc.padckotlin.mvp.presenters

import com.padc.padckotlin.mvp.views.BaseView

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-09-29.
 */

abstract class BasePresenter<T: BaseView> {

    protected lateinit var mView: T

    open fun initPresenter(view: T){
        this.mView  = view
    }

    open fun onStart() {}

    open fun onCreate(){}

    open  fun onResume(){}

    open fun onPause(){}

    open fun onStop(){}

    open fun onDestory(){}


}