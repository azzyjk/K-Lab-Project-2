package com.example.communcationingarden.di.module

import com.example.communcationingarden.data.source.activity.ActivityDataSource
import com.example.communcationingarden.data.source.activity.ActivityRepository
import com.example.communcationingarden.data.source.activity.ActivityRepositoryImpl
import com.example.communcationingarden.data.source.activity.remote.ActivityRemoteDataSource
import com.example.communcationingarden.data.source.garden.GardenDataSource
import com.example.communcationingarden.data.source.garden.GardenRepository
import com.example.communcationingarden.data.source.garden.GardenRepositoryImpl
import com.example.communcationingarden.data.source.garden.remote.GardenRemoteDataSource
import com.example.communcationingarden.data.source.login.LoginDataSource
import com.example.communcationingarden.data.source.login.LoginRepository
import com.example.communcationingarden.data.source.login.LoginRepositoryImpl
import com.example.communcationingarden.data.source.login.remote.LoginRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    
    @Singleton
    @Binds
    abstract fun bindActivityRemoteDataSource(
        activityRemoteDataSource: ActivityRemoteDataSource
    ): ActivityDataSource.Remote
    
    @Singleton
    @Binds
    abstract fun bindActivityRepository(
        activityRepositoryImpl: ActivityRepositoryImpl
    ): ActivityRepository
    
    @Singleton
    @Binds
    abstract fun bindGardenRemoteDataSource(
        gardenRemoteDataSource: GardenRemoteDataSource
    ): GardenDataSource.Remote
    
    @Singleton
    @Binds
    abstract fun bindGardenRepository(
        gardenRepositoryImpl: GardenRepositoryImpl
    ): GardenRepository
    
    @Singleton
    @Binds
    abstract fun bindLoginRemoteDataSource(
        loginRemoteDataSource: LoginRemoteDataSource
    ): LoginDataSource.Remote
    
    @Singleton
    @Binds
    abstract fun bindLoginRepository(
        loginRepositoryImpl: LoginRepositoryImpl
    ): LoginRepository
}

