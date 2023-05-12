package com.example.misw4203moviles2023.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.misw4203moviles2023.data.model.AlbumModel
import com.example.misw4203moviles2023.domain.album.GetAlbums
import com.example.misw4203moviles2023.domain.album.model.Album
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TIMESTAMPT_REGEX_END = 10

@HiltViewModel
class AlbumListViewModel @Inject constructor(private val getAlbums:GetAlbums) : ViewModel() {

    val albumModel = MutableLiveData<List<Album>?>()
    private val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getAlbums()
            result?.forEach {
                it.releaseDate =
                    it.releaseDate.substring(0, TIMESTAMPT_REGEX_END).split("-").reversed()
                        .joinToString("/")
            }
            val sortedResult = result?.sortedByDescending { it.name }
            if (result?.isNotEmpty() == true) {
                albumModel.postValue(sortedResult)
                isLoading.postValue(false)
            }
        }
    }
}
