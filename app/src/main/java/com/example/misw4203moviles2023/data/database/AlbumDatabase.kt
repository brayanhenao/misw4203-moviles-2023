package com.example.misw4203moviles2023.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.misw4203moviles2023.data.database.dao.AlbumDao
import com.example.misw4203moviles2023.data.database.entities.AlbumEntity
import com.example.misw4203moviles2023.data.database.entities.TrackEntity

@Database(entities = [AlbumEntity::class, TrackEntity::class], version = 1)
@TypeConverters(DatabaseListConverter::class)
abstract class AlbumDatabase:RoomDatabase() {
    abstract fun getAlbums():AlbumDao
}