package com.example.logonrm.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.logonrm.demoaacretrofit.entities.AddressReponse
import com.example.logonrm.demoaacretrofit.repositories.AddressRepository
import com.example.logonrm.demoaacretrofit.repositories.AddressRepositoryImpl

/**
 * Created by logonrm on 03/03/2018.
 */
class MainViewModel: ViewModel() {

    val isLoading : MutableLiveData<Boolean> = MutableLiveData()

    private val addressRepository: AddressRepository
    private val mApiResponse: MediatorLiveData<AddressReponse> = MediatorLiveData()

    val apiResponse: LiveData<AddressReponse>
        get() = mApiResponse

    init {
        addressRepository = AddressRepositoryImpl()
    }

    fun searchAddress(cep: String): LiveData<AddressReponse>{
        isLoading.postValue(true)
        mApiResponse.addSource(addressRepository.searchAddress(cep)){
            apiResponse -> mApiResponse.value = apiResponse
            isLoading.postValue(false)
        }

        return mApiResponse
    }
}