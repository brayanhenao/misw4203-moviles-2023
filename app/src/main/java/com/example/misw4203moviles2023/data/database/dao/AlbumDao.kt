package com.example.misw4203moviles2023.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.misw4203moviles2023.data.database.entities.AlbumEntity

@Dao
interface AlbumDao {

    @Query("SELECT * FROM album_table ORDER BY name DESC")
    suspend fun getAllAlbums():List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(albums:List<AlbumEntity>)

    @Query("Delete from  album_table")
    suspend fun deleteAllAlbums()
}