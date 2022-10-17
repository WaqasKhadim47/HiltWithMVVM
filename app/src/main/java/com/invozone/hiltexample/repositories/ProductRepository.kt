package com.invozone.hiltexample.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.invozone.hiltexample.db.MyDb
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.models.QuoteList
import com.invozone.hiltexample.models.Result

import com.invozone.hiltexample.retrofits.MyApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val myApi: MyApi, private val myDb : MyDb) {

    companion object{
        const val TAG = "RETROFIT"
    }
    private val _quotes = MutableLiveData<Response<QuoteList>>()
    val quotes: LiveData<Response<QuoteList>>
    get() = _quotes



    suspend fun getQuotes(){
       val result = myApi.getQuotes(1)

        if(result.isSuccessful && result.body() != null) {
            _quotes.postValue(Response.Success(result.body()))
        }else{
            _quotes.postValue(Response.Error(result.message()))
        }
    }


}