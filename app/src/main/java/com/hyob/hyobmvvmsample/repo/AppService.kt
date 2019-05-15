package com.hyob.hyobmvvmsample.repo

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object AppService {

    fun getAppApi() = getRetrofit().create(AppApi::class.java)

    private fun getRetrofit() =
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(getClient())
            .baseUrl("https://openapi.naver.com/v1/")
            .build()

    private fun getClient() =
        OkHttpClient.Builder()
            .callTimeout(10, TimeUnit.SECONDS)
            .addNetworkInterceptor { chain ->
                val req = chain.request()
                    .newBuilder()
                    .addHeader("X-Naver-Client-Id", "aklVRtJ4Pyh7hmAIRG0I")
                    .addHeader("X-Naver-Client-Secret", "wtjCqpIlzm")
                    .build()
                chain.proceed(req)
            }.build()


}