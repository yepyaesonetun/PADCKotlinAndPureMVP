package com.padc.padckotlin.mvp.views

import com.padc.padckotlin.data.vos.EventVO

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-09-29.
 */

interface EventListView : BaseView{
    fun displayEventList(eventList: List<EventVO>)
    fun displayError(errorMessage: String)
    fun navigateToDetail(eventId: Int)
}