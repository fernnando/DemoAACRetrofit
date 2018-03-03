package com.example.logonrm.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.logonrm.demoaacretrofit.api.AddressAPI
import com.example.logonrm.demoaacretrofit.entities.Address
import com.example.logonrm.demoaacretrofit.entities.AddressReponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AddressRepositoryImpl: AddressRepository {

    private val addressAPI: AddressAPI

    init {
        val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://viacep.com.br/")
                .build()

        addressAPI = retrofit.create(AddressAPI::class.java)
    }

    override fun searchAddress(cep: String): LiveData<AddressReponse> {

        val liveData = MutableLiveData<AddressReponse>()

        addressAPI.search(cep)
                .enqueue(object : Callback<Address>{
                    override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                        liveData.value = AddressReponse(response?.body()!!)
                    }

                    override fun onFailure(call: Call<Address>?, t: Throwable?) {
                        liveData.value = AddressReponse(t!!)
                    }

                })

        return liveData
    }
}