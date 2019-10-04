package com.padc.padckotlin.mvp.presenters

import com.padc.padckotlin.data.models.EventModelImpl
import com.padc.padckotlin.delegates.EventItemDelegate
import com.padc.padckotlin.mvp.views.EventListView

/**
 * Created by Ye Pyae Sone Tun
 * on 2019-09-29.
 */

class EventListPresenter: BasePresenter<EventListView>(), EventItemDelegate {
    override fun onTapEventItem(eventId: Int) {
        mView.navigateToDetail(eventId)
    }


    override fun onCreate(){
        val model = EventModelImpl
        model.getEvents(
            { events ->
               mView.displayEventList(events)
            }, {
                mView.displayError(it)
            }
        )
    }
    override fun onStart(){}
    override fun onResume(){}
    override fun onPause(){}
    override fun onStop(){}
    override fun onDestory(){}
}