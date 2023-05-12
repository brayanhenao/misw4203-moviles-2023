package com.example.misw4203moviles2023.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.misw4203moviles2023.domain.album.model.Track

@Entity(tableName = "track_table")
data class TrackEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name")val name: String,
    @ColumnInfo(name = "duration")val duration: String
    )

fun Track.toDatabase()=TrackEntity(id,name,duration)
