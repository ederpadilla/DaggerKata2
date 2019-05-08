package com.example.daggerglobantsamples.fourthsample.di.module

import com.example.daggerglobantsamples.fourthsample.api.SimpsonClient
import com.example.daggerglobantsamples.fourthsample.di.scope.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class RetrofitModule {

    private val BASE_URL = "https://thesimpsonsquoteapi.glitch.me/"

    @ApplicationScope
    @Provides
    fun providesGsonConverter() : GsonConverterFactory{
        return GsonConverterFactory.create()
    }

    @ApplicationScope
    @Provides
    fun providesHttpLoggingInterceptor() : HttpLoggingInterceptor{
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @ApplicationScope
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient{
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor)
            .connectTimeout(20,TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .writeTimeout(20,TimeUnit.SECONDS)
            .build()
    }

    @ApplicationScope
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient,
                         gsonConverterFactory: GsonConverterFactory) : Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @ApplicationScope
    @Provides
    fun providesApiClient(retrofit: Retrofit) : SimpsonClient{
        return retrofit.create(SimpsonClient::class.java)
    }

}