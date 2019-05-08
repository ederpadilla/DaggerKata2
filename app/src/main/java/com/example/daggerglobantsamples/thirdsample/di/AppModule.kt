package com.example.daggerglobantsamples.thirdsample.di

import android.app.Application
import android.content.Context
import com.example.daggerglobantsamples.thirdsample.api.ApiClient
import com.example.daggerglobantsamples.thirdsample.model.User
import com.example.daggerglobantsamples.thirdsample.ui.login.presenter.LoginPresenter
import com.example.daggerglobantsamples.thirdsample.ui.profile.presenter.ProfilePresenter
import com.example.daggerglobantsamples.thirdsample.ui.webservice.presenter.WebServicePresenter
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule(private val application: Application) {
   @Provides
   @Singleton
   fun providesApplication() : Application{
       return application
   }

    @Provides
    @Singleton
    fun providesApplicationContext() : Context{
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesUser() : User {
        return User()
    }

    private val BASE_URL = "https://swapi.co/api/"

    @Provides
    @Singleton
    fun providesGsonConverter() : GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesOkHttp() : OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20,TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient,gsonConverterFactory: GsonConverterFactory) : Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providesApiClient(retrofit: Retrofit) : ApiClient {
        return retrofit.create(ApiClient::class.java)
    }

    @Provides
    @Singleton
    fun providesLoginPresenter(user: User) : LoginPresenter {
        return LoginPresenter(user)
    }

    @Provides
    @Singleton
    fun providesProfilePresenter(user: User) : ProfilePresenter {
        return ProfilePresenter(user)
    }

    @Provides
    @Singleton
    fun providesWebServicePresenter(user : User, apiClient: ApiClient) : WebServicePresenter {
        return WebServicePresenter(user,apiClient)
    }

}