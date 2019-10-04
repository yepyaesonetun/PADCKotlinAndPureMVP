package com.padc.padckotlin.activities

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.padc.padckotlin.R
import com.padc.padckotlin.adapters.EventListAdapter
import com.padc.padckotlin.data.vos.EventVO
import com.padc.padckotlin.delegates.EventItemDelegate
import com.padc.padckotlin.mvp.presenters.EventListPresenter
import com.padc.padckotlin.mvp.views.EventListView
import kotlinx.android.synthetic.main.activity_adapter_based_view.*

class MainActivity : BaseActivity(),EventListView {
    override fun displayError(errorMessage: String) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun displayEventList(eventList: List<EventVO>) {
        mAdapter.setNewData(eventList.toMutableList())
    }

    override fun navigateToDetail(eventId: Int) {
        startActivity(EventDetailActivity.newIntent(applicationContext, eventId))
    }

    private lateinit var mPresenter: EventListPresenter
    private lateinit var mAdapter: EventListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adapter_based_view)
        setSupportActionBar(toolbar)

        mPresenter = EventListPresenter()
        mPresenter.initPresenter(this)


        mAdapter = EventListAdapter(mPresenter)

        with(rvEvents) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }

        mPresenter.onCreate()

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

}
