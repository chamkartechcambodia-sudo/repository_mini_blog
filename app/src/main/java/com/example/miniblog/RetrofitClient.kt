package com.example.miniblog

/**
 * Builds the Retrofit instance and exposes the [ApiService].
 *
 * TODO (Step 1 — branch 01-no-repository): build Moshi (reflection) + Retrofit here, e.g.
 *
 *     private val moshi = Moshi.Builder()
 *         .add(KotlinJsonAdapterFactory())   // reflection adapter — no codegen needed
 *         .build()
 *
 *     val api: ApiService = Retrofit.Builder()
 *         .baseUrl(BASE_URL)
 *         .addConverterFactory(MoshiConverterFactory.create(moshi))
 *         .build()
 *         .create(ApiService::class.java)
 *
 * Left as a stub in the starter so the wiring is added step-by-step.
 */
object RetrofitClient {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    // TODO (Step 1): expose `val api: ApiService` built with Retrofit + Moshi.
}
