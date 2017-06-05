package com.example.zy_git.comicsbykotlin.ui.adapter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.zy_git.comicsbykotlin.R

class ComicActivity : AppCompatActivity() {

    companion object {
        val INTENT_COMIC_URL = "url"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)
    }
}
