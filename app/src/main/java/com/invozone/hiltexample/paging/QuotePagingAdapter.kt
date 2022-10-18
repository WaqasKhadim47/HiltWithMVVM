package com.invozone.hiltexample.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.invozone.hiltexample.R
import com.invozone.hiltexample.models.Result
import kotlinx.coroutines.NonDisposableHandle
import kotlinx.coroutines.NonDisposableHandle.parent

class QuotePagingAdapter : PagingDataAdapter<Result, QuotePagingAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item,parent, false)
        return  ViewHolder((view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val item = getItem(position)
        if(item != null){
            holder.quote.text = item.content
        }
    }



    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val quote = itemView.findViewById<TextView>(R.id.quote)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Result>() {
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem._id == newItem._id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem == newItem
            }
        }
    }


}