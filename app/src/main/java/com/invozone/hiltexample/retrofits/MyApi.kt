package com.invozone.hiltexample.retrofits

import com.invozone.hiltexample.models.QuoteList
import com.invozone.hiltexample.models.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApi {

    @GET("quotes")
    suspend fun getQuotes(@Query("page") page : Int) : Response<QuoteList>


}