package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.logonrm.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btnSearch.setOnClickListener {
            mainViewModel.searchAddress(etSearch.text.toString())
        }

        mainViewModel.apiResponse.observe(this, Observer {
            apiResponse ->
            if(apiResponse?.error == null){
                tvAddress.text = apiResponse?.address?.logradouro
            }
            else{
                Log.i("TAG", "ERRO")
            }
        })

        mainViewModel.isLoading.observe(this, Observer {
            isLoading -> if(isLoading!!){
                Log.i("TAG", "LOADING")
            }else{
                Log.i("TAG", "NOT LOADING")
            }
        })
    }
}
