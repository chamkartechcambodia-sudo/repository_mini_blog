package com.example.miniblog

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Builds the Retrofit instance and exposes the [ApiService].
 *
 * Moshi uses its REFLECTION adapter ([KotlinJsonAdapterFactory]) so we need NO annotation
 * processor / codegen to parse JSON into our Kotlin [Post] data class.
 */
object RetrofitClient {

    const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val api: ApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(ApiService::class.java)
}
