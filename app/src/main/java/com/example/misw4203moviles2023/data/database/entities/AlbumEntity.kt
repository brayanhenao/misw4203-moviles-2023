package com.example.misw4203moviles2023.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.misw4203moviles2023.data.database.entities.TrackEntity
import com.example.misw4203moviles2023.domain.album.model.Album

@Entity(tableName = "album_table")
data class AlbumEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "cover") val cover: String,
    @ColumnInfo(name = "releaseDate") var releaseDate: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "genre") val genre: String,
    @ColumnInfo(name = "recordLabel") val recordLabel: String,
    @ColumnInfo(name = "tracks") val tracks: List<TrackEntity>,
)

fun Album.toDatabase()=AlbumEntity(id, name, cover, releaseDate, description, genre, recordLabel, tracks.map{ it.toDatabase() })
