package com.flying.xiaopo.poishuhui_kotlin.domain.network

import com.flying.xiaopo.poishuhui_kotlin.domain.model.Cover
import com.flying.xiaopo.poishuhui_kotlin.getHtml
import org.jsoup.Jsoup
import java.util.*

/**
 * @author wupanjie
 */
class CoverSource : Source<ArrayList<Cover>> {
    override fun obtain(url: String): ArrayList<Cover> {
        val list = ArrayList<Cover>()
        val html = getHtml(url)
        val doc = Jsoup.parse(html)

        val elements = doc.select("ul.mangeListBox").select("li")
        for (element in elements) {
            val coverUrl = element.select("img").attr("src")
            val title = element.select("h1").text() + "\n" + element.select("h2").text()
            val link = "http://ishuhui.net" + element.select("div.magesPhoto").select("a").attr("href")
            val cover = Cover(coverUrl, title, link)
            list.add(cover)
        }

        return list
    }

}