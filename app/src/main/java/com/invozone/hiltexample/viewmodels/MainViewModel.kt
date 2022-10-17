package com.invozone.hiltexample.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.models.Product
import com.invozone.hiltexample.models.ProductList
import com.invozone.hiltexample.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {

     val productLiveData : LiveData<Response<ProductList>>
     get() = repository.products

    val one : LiveData<Product>
    get() = repository.oneProduct


     init {
         viewModelScope.launch {
             repository.getProducts()
             Log.d("Log", "Fetching data")
         }

         viewModelScope.launch {
             repository.getOneProduct(10)
         }


     }
}