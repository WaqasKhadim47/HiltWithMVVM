package com.invozone.hiltexample.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.invozone.hiltexample.db.MyDb
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.models.QuoteList
import com.invozone.hiltexample.models.Result
import com.invozone.hiltexample.paging.QuotePagingSource

import com.invozone.hiltexample.retrofits.MyApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val myApi: MyApi, private val myDb : MyDb) {

    companion object{
        const val TAG = "RETROFIT"
    }


     fun getQuotes() = Pager(
         config = PagingConfig(pageSize = 30, maxSize = 100),
         pagingSourceFactory = {QuotePagingSource(myApi)}
     ).liveData


}