package com.invozone.hiltexample.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.models.QuoteList
import com.invozone.hiltexample.models.Result
import com.invozone.hiltexample.repositories.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch


import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel() {


    val quotes = repository.getQuotes()

//     init {
//         viewModelScope.launch {
//             repository.getQuotes()
//             Log.d("Log", "Fetching data")
//         }
//
//
//
//
//     }
}