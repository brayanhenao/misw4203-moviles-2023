package com.example.misw4203moviles2023.domain.album

import com.example.misw4203moviles2023.data.AlbumRepository
import com.example.misw4203moviles2023.data.database.entities.toDatabase
import com.example.misw4203moviles2023.data.model.AlbumModel
import com.example.misw4203moviles2023.domain.album.model.Album
import javax.inject.Inject

class GetAlbums @Inject constructor(private val repository:AlbumRepository) {
    suspend operator fun invoke(): List<Album> {
        val albums = repository.getAllAlbumsFromApi()

       return if (albums.isNotEmpty()){
           repository.clearAlbums()
           repository.insertAlbums(albums.map { it.toDatabase() })
           return albums
        }else{
            repository.getAllAlbumsFromDB()
        }
    }
}
