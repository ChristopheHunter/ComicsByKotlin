package com.example.zy_git.comicsbykotlin.ui.activity

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.zy_git.comicsbykotlin.R
import com.example.zy_git.comicsbykotlin.ui.adapter.ContentPagerAdapter
import com.example.zy_git.comicsbykotlin.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val GITHUB_URL = "http://www.baidu.com"
    }

    val nameResList: ArrayList<Int> = arrayListOf(R.string.tab_one, R.string.tab_two, R.string.tab_three)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)
        fab.setOnClickListener { jumpToGithub() }
        var fragments = ArrayList<Fragment>()

        fragments.add(HomeFragment())
        fragments.add(HomeFragment())
        fragments.add(HomeFragment())

        val nameList = nameResList.map(this::getString)
//        val nameList = listOf("1", "2", "3")
        viewPager.adapter = ContentPagerAdapter(fragments, nameList, supportFragmentManager)
        viewPager.offscreenPageLimit = 2
        tablayout.setupWithViewPager(viewPager)

    }

    private fun jumpToGithub() {
        val uri = Uri.parse(GITHUB_URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}
