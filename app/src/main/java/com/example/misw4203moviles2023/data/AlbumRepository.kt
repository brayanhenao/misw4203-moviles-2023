package com.example.misw4203moviles2023.data

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.misw4203moviles2023.data.database.AlbumDatabase
import com.example.misw4203moviles2023.data.database.dao.AlbumDao
import com.example.misw4203moviles2023.data.database.dao.AlbumDaoService
import com.example.misw4203moviles2023.data.database.entities.AlbumEntity
import com.example.misw4203moviles2023.data.model.AlbumModel
import com.example.misw4203moviles2023.data.network.AlbumService
import com.example.misw4203moviles2023.domain.album.model.Album
import com.example.misw4203moviles2023.domain.album.model.toDomain
import javax.inject.Inject

class AlbumRepository @Inject constructor (private val api:AlbumService, private val albumDao: AlbumDao) {
    suspend fun getAllAlbumsFromApi(): List<Album> {
        val response: List<AlbumModel> = api.getAlbums()
        return response.map { it.toDomain() }
    }
    suspend fun getAllAlbumsFromDB(): List<Album> {
        val response = albumDao.getAllAlbums()
        return response.map { it.toDomain() }
    }

    suspend fun insertAlbums(albums:List<AlbumEntity>){
        albumDao.insertAll(albums)
    }

    suspend fun clearAlbums(){
        albumDao.deleteAllAlbums()
    }

    suspend fun getAlbumById(id: Int): Album {
        val response = api.getAlbumById(id)
        return response.toDomain()
    }
}
