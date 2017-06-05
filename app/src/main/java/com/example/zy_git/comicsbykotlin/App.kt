package com.example.zy_git.comicsbykotlin

import android.app.Application
import com.squareup.picasso.LruCache
import com.squareup.picasso.Picasso

/**
 * Created by zy_git on 2017/6/3.
 */
class App : Application(){

    private val TAG = App::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        val maxMen = Runtime.getRuntime().maxMemory().toInt()
        Picasso.Builder(this).memoryCache(LruCache(maxMen / 8)).build()
    }

}
