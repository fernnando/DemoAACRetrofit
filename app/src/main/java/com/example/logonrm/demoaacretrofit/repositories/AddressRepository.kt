package com.example.logonrm.demoaacretrofit.repositories

import android.arch.lifecycle.LiveData
import com.example.logonrm.demoaacretrofit.entities.AddressReponse

interface AddressRepository {
    fun searchAddress(cep: String): LiveData<AddressReponse>
}