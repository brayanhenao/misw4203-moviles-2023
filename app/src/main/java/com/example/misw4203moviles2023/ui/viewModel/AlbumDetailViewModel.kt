package com.example.misw4203moviles2023.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.misw4203moviles2023.data.model.AlbumModel
import com.example.misw4203moviles2023.domain.album.GetAlbumById
import com.example.misw4203moviles2023.domain.album.GetAlbums
import com.example.misw4203moviles2023.domain.album.model.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TIMESTAMPT_REGEX_END = 10

@HiltViewModel
class AlbumDetailViewModel @Inject constructor(private val getAlbumById: GetAlbumById) : ViewModel() {

    val albumModel = MutableLiveData<Album>()
    private val isLoading = MutableLiveData<Boolean>()

    fun onCreate(albumId: Int) {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAlbumById(albumId)
            result.releaseDate =
                result.releaseDate.substring(0, TIMESTAMPT_REGEX_END).split("-").reversed()
                    .joinToString("/")
            albumModel.postValue(result)
            isLoading.postValue(false)
        }
    }
}
