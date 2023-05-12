package com.example.misw4203moviles2023.core.di

import android.content.Context
import androidx.room.Room
import com.example.misw4203moviles2023.data.database.AlbumDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val DB_NAME = "misw4203moviles2023"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context, AlbumDatabase::class.java, DB_NAME).build()

    @Singleton
    @Provides
    fun provideAlbumDao(db:AlbumDatabase) = db.getAlbums()

}