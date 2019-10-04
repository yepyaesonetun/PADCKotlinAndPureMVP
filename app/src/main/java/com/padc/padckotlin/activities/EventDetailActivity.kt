package com.padc.padckotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import coil.api.load
import com.padc.padckotlin.R
import com.padc.padckotlin.adapters.EventDetailImageAdapter
import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.mvp.presenters.EventDetailPresenter
import com.padc.padckotlin.mvp.views.EventDetailView
import kotlinx.android.synthetic.main.activity_event_details.*

class EventDetailActivity: BaseActivity(), EventDetailView {
    override fun displayEventData(eventData: EventVO) {
        bindData(eventData)
    }

    private lateinit var mPresenter: EventDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_details)
        setSupportActionBar(toolbar)

        vpEventDetailImages.adapter = EventDetailImageAdapter()

        mPresenter = EventDetailPresenter()
        mPresenter.initPresenter(this)

        val eventId = intent.getIntExtra(EXTRA_EVENT_ID, 0)
        mPresenter.onUIReady(eventId)

        mPresenter.onCreate()

    }

    private fun bindData(eventVO: EventVO) {
        tvEventTitle.text = eventVO.eventName
        collapsingToolbar.title = eventVO.eventName


        ivTagImage.load(eventVO.eventOrganizerVO.organizerPhotoUrl){
            crossfade(true)
            crossfade(2000)
        }

        tvDate.text = eventVO.eventStartTime
        tvCategory.text = eventVO.eventType.toString()
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestory()
    }

    companion object {

        const val EXTRA_EVENT_ID = "eventIdExtra"

        fun newIntent(context: Context, eventId: Int): Intent {
            return Intent(context, EventDetailActivity::class.java).apply {
                putExtra(EXTRA_EVENT_ID, eventId)
            }

        }
    }
}