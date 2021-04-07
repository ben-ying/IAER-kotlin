package com.yjh.iaer.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.yjh.iaer.room.entity.DatabaseUser
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private const val BASE_URL = "http://mybackend.online:8000/iaer/api/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    @FormUrlEncoded
    @POST("user/login/")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Deferred<CustomResponse<DatabaseUser>>

}

object RetrofitApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}