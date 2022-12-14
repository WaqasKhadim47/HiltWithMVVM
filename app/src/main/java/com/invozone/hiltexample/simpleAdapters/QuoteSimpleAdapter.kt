package com.invozone.hiltexample.simpleAdapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.invozone.hiltexample.R
import com.invozone.hiltexample.models.QuoteList

class QuoteSimpleAdapter(val quoteList: QuoteList, val  context: Context) : RecyclerView.Adapter<QuoteSimpleAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_item, parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = quoteList.results[position]
        if(item != null){
            holder.quote.text = item.content
        }
    }

    override fun getItemCount(): Int {
        if(quoteList!= null){
            return quoteList.results.size
        }else{
            return 0
        }

    }

    inner  class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val quote = itemView.findViewById<TextView>(R.id.quote)
    }


}