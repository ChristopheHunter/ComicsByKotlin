package com.example.zy_git.comicsbykotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.zy_git.comicsbykotlin.R
import com.flying.xiaopo.poishuhui_kotlin.domain.model.Cover
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_cover.view.*

/**
 * Created by zy_git on 2017/6/5.
 */
class CoverAdapter(
        var data: List<Cover> = ArrayList(),
        var itemCLick: (View, Int) -> Unit) : RecyclerView.Adapter<CoverAdapter.CoverViewHolder>() {

    override fun onBindViewHolder(holder: CoverViewHolder, position: Int) {
        val cover = data[position]
        holder.itemView.tv_cover.text = cover.title
        Picasso.with(holder.itemView.context).load(cover.coverUrl).into(holder.itemView.iv_cover)
        holder.itemView.coverContainer.setOnClickListener {
            itemCLick(holder.itemView, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoverViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cover, parent, false)
        return CoverViewHolder(itemView)
    }

    override fun getItemCount(): Int = data.size

    fun refreshData(newData: List<Cover>){
        data = newData
        notifyDataSetChanged()
    }

    class CoverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}