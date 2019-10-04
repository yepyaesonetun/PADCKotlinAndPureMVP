package com.padc.padckotlin.mvp.views

import com.padc.padckotlin.data.vos.EventVO

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-09-29.
 */

interface EventDetailView : BaseView{
    fun displayEventData(eventData: EventVO)
}