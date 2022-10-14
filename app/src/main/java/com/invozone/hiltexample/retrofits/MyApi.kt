package com.invozone.hiltexample.retrofits

import com.invozone.hiltexample.models.Product
import com.invozone.hiltexample.models.ProductList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApi {

    @GET("products")
    suspend fun getProducts() : Response<ProductList>

    @GET("products/{id}")
    suspend fun getSingleProduct(@Path("id") id : Int): Response<Product>
}