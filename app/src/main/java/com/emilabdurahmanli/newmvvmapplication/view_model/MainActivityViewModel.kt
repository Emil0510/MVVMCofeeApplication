package com.emilabdurahmanli.newmvvmapplication.view_model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emilabdurahmanli.newmvvmapplication.model.Result
import com.emilabdurahmanli.newmvvmapplication.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivityViewModel : ViewModel() {

    var coffeeImage = MutableLiveData<String>()
     fun getCoffeeImage(context : Context) {
        val call: Call<Result?>? = RetrofitClient.getRetrofitInstance()?.getApi()?.getCoffeeImage()
        call?.enqueue(object : Callback<Result?> {
            override fun onResponse(call: Call<Result?>?, response: Response<Result?>) {
                val coffeeImage: Result? = response.body()
                this@MainActivityViewModel.coffeeImage.postValue(coffeeImage?.file)
            }
            override fun onFailure(call: Call<Result?>?, t: Throwable?) {
                Toast.makeText(context, "An error has occured", Toast.LENGTH_LONG)
                    .show()
            }
        })
    }

    fun observeCoffeeImage() : LiveData<String>{
        return coffeeImage
    }

}