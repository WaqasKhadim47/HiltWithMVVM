package com.invozone.hiltexample.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.invozone.hiltexample.db.MyDb
import com.invozone.hiltexample.models.Product
import com.invozone.hiltexample.models.ProductList

import com.invozone.hiltexample.retrofits.MyApi
import javax.inject.Inject

class ProductRepository @Inject constructor(private val myApi: MyApi, private val myDb : MyDb) {

    companion object{
        const val TAG = "RETROFIT"
    }
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
    get() = _products

    // get single product from database

    private val _oneProduct = MutableLiveData<Product>()
    val oneProduct : LiveData<Product>
    get() = _oneProduct

    suspend fun getProducts(){
       val result = myApi.getProducts()
        if(result.isSuccessful && result.body() != null) {
            myDb.getDao().addProducts(result.body()!!.products)
            _products.postValue(result.body()!!.products)
        }
    }

    suspend fun getOneProduct(id : Int) {
        val result = myApi.getSingleProduct(id)
        Log.d(TAG, result.body().toString())
        if(result.isSuccessful && result.body()!= null){
            _oneProduct.postValue(result.body()!!)
        }
    }
}