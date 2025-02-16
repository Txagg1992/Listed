package com.curiousapps.listed.di

import com.curiousapps.listed.data.ListIdRepositoryImpl
import com.curiousapps.listed.domain.ListIdRepository
import com.curiousapps.listed.network.ListedApi
import com.curiousapps.listed.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideListedRepo(
        api: ListedApi
    ): ListIdRepository = ListIdRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideListedApi(): ListedApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ListedApi::class.java)
    }
}