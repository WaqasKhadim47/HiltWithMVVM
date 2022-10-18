package com.invozone.hiltexample

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.invozone.hiltexample.base.BaseActivity
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.paging.LoaderAdapter
import com.invozone.hiltexample.paging.QuotePagingAdapter
import com.invozone.hiltexample.repositories.ProductRepository.Companion.TAG
import com.invozone.hiltexample.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: QuotePagingAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recycleView)
        adapter = QuotePagingAdapter()

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()
        recyclerView.adapter = adapter.withLoadStateHeaderAndFooter(
            header = LoaderAdapter(),
            footer = LoaderAdapter()
        )


        mainViewModel.quotes.observe(this, Observer { quotes ->
            adapter.submitData(lifecycle, quotes)
//            when(it){
//                is Response.Loading -> {
//
//                }
//                is Response.Success -> {
//                   it.data.let {
//                       Log.d(TAG, it!!.results.toString())
//
//
//                   }
//                }
//                is Response.Error -> {
//                    it.message.let {
//                        Log.e(TAG, it.toString())
//                    }
//                }
//            }
        })



    }
}