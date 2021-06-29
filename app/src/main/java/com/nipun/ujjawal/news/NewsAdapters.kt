package com.nipun.ujjawal.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nipun.ujjawal.R
import kotlinx.android.synthetic.main.news_item_layout.view.*


class NewsAdapters(val newsList: List<Data>) :
    RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_item_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val data: Data = newsList.get(position)
        holder.setNewsItem(data)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}

class NewsViewHolder(val view: View) :
    RecyclerView.ViewHolder(view) {

    fun setNewsItem(data: Data) {
        view.apply {
            tvNewsTitle.text = data.title.toString()
            tvNewsAuthor1.text = data.content.toString()
            tvDate1.text = data.time.toString()


        }
        view.apply {
            Glide.with(this).load(data.imageUrl).into(ivNewsImage)
        }
    }
}