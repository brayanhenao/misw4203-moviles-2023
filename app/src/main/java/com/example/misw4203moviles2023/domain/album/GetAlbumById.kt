package com.example.misw4203moviles2023.domain.album

import com.example.misw4203moviles2023.data.AlbumRepository
import com.example.misw4203moviles2023.data.model.AlbumModel
import com.example.misw4203moviles2023.domain.album.model.Album
import javax.inject.Inject

class GetAlbumById @Inject constructor(private val repository:AlbumRepository) {
    suspend operator fun invoke(id: Int): Album = repository.getAlbumById(id)
}
