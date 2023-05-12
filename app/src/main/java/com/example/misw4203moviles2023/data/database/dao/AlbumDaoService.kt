package com.example.misw4203moviles2023.data.database.dao

import android.content.Context
import androidx.room.Room
import com.example.misw4203moviles2023.data.database.AlbumDatabase
import com.example.misw4203moviles2023.data.database.entities.AlbumEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class AlbumDaoService(private val context: Context){

    private val DB_NAME = "misw4203moviles2023"
    private val provideRoom = Room.databaseBuilder(context.applicationContext,AlbumDatabase::class.java, DB_NAME).build()

    suspend fun getAlbums():List<AlbumEntity>{
        return withContext(Dispatchers.IO){
            val response = provideRoom.getAlbums().getAllAlbums()
            response ?: emptyList()
        }
    }
}