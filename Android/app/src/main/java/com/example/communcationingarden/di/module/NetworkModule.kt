package com.example.communcationingarden.di.module

import com.example.communcationingarden.network.ActivityRetrofitService
import com.example.communcationingarden.network.GardenPictureRetrofitService
import com.example.communcationingarden.network.GardenRetrofitService
import com.example.communcationingarden.network.LoginRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    const val KLAB_BASE_URL = "https://klab0.herokuapp.com"
    
    @Singleton
    @Provides
    fun provideLoginRetrofitService() =
        Retrofit.Builder()
            .baseUrl(KLAB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoginRetrofitService::class.java)
    
    @Singleton
    @Provides
    fun provideHomeRetrofitService() =
        Retrofit.Builder()
            .baseUrl(KLAB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GardenRetrofitService::class.java)
    
    @Singleton
    @Provides
    fun provideActivityRetrofitService() =
        Retrofit.Builder()
            .baseUrl(KLAB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ActivityRetrofitService::class.java)
    
    @Singleton
    @Provides
    fun provideGardenPictureRetrofitService() =
        Retrofit.Builder()
            .baseUrl(KLAB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GardenPictureRetrofitService::class.java)
}
