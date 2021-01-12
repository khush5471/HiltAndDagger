package com.example.kotlin_shoppingcart.views.apihelper

import com.example.hiltanddaggerpractice.network.WebService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ApiHelper {

    //    @Inject var  dd:MainActivity?=null
//
//
    private val TIMEOUT = 30L
    private val mRetrofit: Retrofit
    private val mService: WebService
    private const val CONNECTION_TIME_OUT: Long = 60

    //
//
//    // Creating Retrofit Object
    init {
        mRetrofit = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")//127.0.0.1:443 // This is for live server
            .addConverterFactory(GsonConverterFactory.create())
//            .client(getUnsafeOkHttpClient().build())//this is for sslhandshake exception
            .client(getClient())
            .build()

        mService = mRetrofit.create(WebService::class.java)


    }

    //
    @Provides
    @Singleton
    fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")//127.0.0.1:443 // This is for live server
            .addConverterFactory(GsonConverterFactory.create())
//            .client(getUnsafeOkHttpClient().build())//this is for sslhandshake exception
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun getOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()

            chain.proceed(request.build())
        }
        return httpClient.build()
    }

    @Provides
    @Singleton
    fun getServiceInstance(retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }


    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
            .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(2, TimeUnit.MINUTES)
            .addInterceptor(interceptor)
        httpClient.addInterceptor { chain ->
            val request = chain.request().newBuilder()

            chain.proceed(request.build())
        }
        return httpClient.build()
    }

    //
    fun getService(): WebService {
        return mService
    }
//


}