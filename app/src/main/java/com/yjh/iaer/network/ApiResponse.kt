package com.yjh.iaer.network

class CustomResponse<T> {
    var message: String? = null

    var code = 0

    var result: T? = null

    val isSuccessful: Boolean
        get() = code == SUCCESS_CODE

    companion object {
        const val SUCCESS_CODE = 200
    }
}