package com.emilabdurahmanli.newmvvmapplication.api

import com.emilabdurahmanli.newmvvmapplication.model.Result
import retrofit2.Call
import retrofit2.http.GET




interface Api {

    @GET("random.json")
    fun getCoffeeImage(): Call<Result?>?

}