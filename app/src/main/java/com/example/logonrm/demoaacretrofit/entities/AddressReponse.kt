package com.example.logonrm.demoaacretrofit.entities

/**
 * Created by logonrm on 03/03/2018.
 */
class AddressReponse {
    var address: Address?
    var error: Throwable?

    constructor(address: Address){
        this.address = address
        this.error = null
    }

    constructor(error: Throwable){
        this.address = null
        this.error = error
    }

}