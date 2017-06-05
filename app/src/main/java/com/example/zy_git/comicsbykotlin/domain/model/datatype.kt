package com.flying.xiaopo.poishuhui_kotlin.domain.model

/**
 * @author wupanjie
 * 实体类s
 */
data class Cover(val coverUrl: String, val title: String, val link: String)

data class News(val title: String, val createdTime: String, val link: String)

data class NewsContainer(val title: String, val newsList: List<News>)

data class BookInfo(val updateTime: String, val description: String)

data class Page(val title: String, val link: String)

data class BookDetail(val pages: List<Page>, val info: BookInfo) {
    operator fun get(position: Int) = pages[position]
    fun size() = pages.size
}

data class Comic(val comicUrl: String)
