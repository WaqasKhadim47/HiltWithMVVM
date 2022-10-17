package com.invozone.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.invozone.hiltexample.base.BaseActivity
import com.invozone.hiltexample.errorhandling.Response
import com.invozone.hiltexample.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {


    lateinit var mainViewModel: MainViewModel








    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainViewModel.productLiveData.observe(this, Observer {
            when(it){
                is Response.Loading -> {
                    pTextView.text = "Loading....."
                }
                is Response.Success -> {
                   it.data.let {
                       pTextView.text = it!!.products.joinToString { it.title + "\n" }
                   }
                }
                is Response.Error -> {
                    it.message.let {
                        pTextView.text = it.toString()
                    }
                }
            }
        })



    }
}