package com.example.misw4203moviles2023.domain.album.model

import com.example.misw4203moviles2023.data.database.entities.AlbumEntity
import com.example.misw4203moviles2023.data.database.entities.TrackEntity
import com.example.misw4203moviles2023.data.model.AlbumModel

data class Album(
    val id: Int,
    val name: String,
    val cover: String,
    var releaseDate: String,
    val description: String,
    val genre: String,
    val recordLabel: String,
    val tracks: List<Track>
    )

fun AlbumModel.toDomain() = Album(id, name, cover, releaseDate, description, genre, recordLabel, tracks.map { it.toDomain() })
fun AlbumEntity.toDomain() = Album(id, name, cover, releaseDate, description, genre, recordLabel, tracks.map { it.toDomain() })