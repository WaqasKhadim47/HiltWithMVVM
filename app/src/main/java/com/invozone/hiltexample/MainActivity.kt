package com.invozone.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.invozone.hiltexample.base.BaseActivity
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.paging.QuoteDataAdapter
import com.invozone.hiltexample.repositories.ProductRepository.Companion.TAG
import com.invozone.hiltexample.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    lateinit var mainViewModel: MainViewModel
    lateinit var recyclerView: RecyclerView
    lateinit var quoteDataAdapter: QuoteDataAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


         recyclerView = findViewById(R.id.recycleView)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.hasFixedSize()





        mainViewModel.productLiveData.observe(this, Observer {
            when(it){
                is Response.Loading -> {

                }
                is Response.Success -> {
                   it.data.let {
                       Log.d(TAG, it!!.results.toString())
                       quoteDataAdapter = QuoteDataAdapter(it!!, applicationContext)
                       recyclerView.adapter = quoteDataAdapter

                   }
                }
                is Response.Error -> {
                    it.message.let {
                        Log.e(TAG, it.toString())
                    }
                }
            }
        })



    }
}