package com.example.logonrm.demoaacretrofit.api

import com.example.logonrm.demoaacretrofit.entities.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface AddressAPI {
    @GET("ws/{cep}/json/")

    fun search(@Path("cep") cep : String): Call<Address>
}