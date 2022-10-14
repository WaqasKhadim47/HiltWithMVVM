package com.invozone.hiltexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.invozone.hiltexample.base.BaseActivity
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

        mainViewModel.productLiveData.observe(this, {
            pTextView.text = it.joinToString { x -> x.title + "\n" }
        })



    }
}