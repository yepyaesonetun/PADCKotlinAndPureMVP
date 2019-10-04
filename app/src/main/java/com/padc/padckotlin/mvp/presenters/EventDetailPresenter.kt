package com.padc.padckotlin.mvp.presenters

import com.padc.padckotlin.data.models.EventModelImpl
import com.padc.padckotlin.mvp.views.EventDetailView

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-09-29.
 */

class EventDetailPresenter : BasePresenter<EventDetailView>() {

    fun onUIReady(eventId: Int){
        if (eventId != 0){
            val model = EventModelImpl
            val eventVO = model.getEventById(eventId)
            mView.displayEventData(eventVO)
        }

    }

    override fun onCreate(){}
    override fun onStart(){}
    override fun onResume(){}
    override fun onPause(){}
    override fun onStop(){}
    override fun onDestory(){}

}