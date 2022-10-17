package com.invozone.hiltexample.errorhandling



sealed class Response<T>(val data: T? = null, val message: String? = null){
    class Loading<T> : Response<T>()
    class Success<T>(productList: T? = null): Response<T>(data = productList)
    class Error<T>(errorMessage: String? =null): Response<T>(message = errorMessage)
}
