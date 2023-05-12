package com.example.misw4203moviles2023.core.di

import com.example.misw4203moviles2023.core.RetrofitHelper
import com.example.misw4203moviles2023.data.network.AlbumApiClient
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
    private const val BASE_URL = "https://back-vynils.herokuapp.com/"

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideAlbumApiClient(retrofit: Retrofit):AlbumApiClient{
        return retrofit.create(AlbumApiClient::class.java)
    }
}