package com.example.zy_git.comicsbykotlin.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zy_git.comicsbykotlin.R
import com.example.zy_git.comicsbykotlin.ui.adapter.ComicActivity
import com.example.zy_git.comicsbykotlin.ui.adapter.CoverAdapter
import com.flying.xiaopo.poishuhui_kotlin.domain.model.Cover
import com.flying.xiaopo.poishuhui_kotlin.domain.network.CoverSource
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.support.v4.find
import org.jetbrains.anko.uiThread

/**
 * Created by zy_git on 2017/6/5.
 */
class HomeFragment : Fragment() {

    companion object {
        val AIM_URL = "http://ishuhui.net/?PageIndex=1"
    }

    var mData = ArrayList<Cover>()

    lateinit var coverList: RecyclerView
    lateinit var homeRefresh: SwipeRefreshLayout
    lateinit var adapter: CoverAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        homeRefresh = find(R.id.homeRefresh)
        coverList = find(R.id.homeList)

        coverList.layoutManager = GridLayoutManager(context, 2)
        adapter = CoverAdapter { view: View, position: Int -> jumpToComic(position) }
        coverList.adapter = adapter

        homeRefresh.setOnRefreshListener{ load() }
        homeRefresh.post { homeRefresh.isRefreshing = true }
    }

    private fun jumpToComic(position: Int) {
        var intent = Intent(context, ComicActivity().javaClass)
        intent.putExtra(ComicActivity.INTENT_COMIC_URL, mData[position].link)
        startActivity(intent)
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser && mData.size == 0){
            load()
        }
    }

    private fun load() {
        Log.d("TTTT", "load函数")
        doAsync {
            val data = CoverSource().obtain(AIM_URL)
            uiThread {
                mData = data
                adapter.refreshData(mData)
                homeRefresh.isRefreshing = false
            }
        }
    }

}