package com.example.misw4203moviles2023.data

import com.example.misw4203moviles2023.core.RetrofitHelper
import com.example.misw4203moviles2023.data.AlbumRepository
import com.example.misw4203moviles2023.data.model.AlbumModel
import com.example.misw4203moviles2023.data.network.AlbumService
import com.example.misw4203moviles2023.test.TestApplication
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Response

@Config(application= TestApplication::class)
@RunWith(RobolectricTestRunner::class)
class AlbumRepositoryTest {
    private lateinit var repository: AlbumRepository

    @Mock
    private lateinit var mockService: AlbumService

    @Before
    fun setUp() {
        mockService = mock(AlbumService::class.java)
        repository = AlbumRepository(mockService)
    }

    @Test
    fun `getAllAlbums should return empty list when api returns null`() = runTest {
        // Given
        whenever(mockService.getAlbums()).thenReturn(emptyList())

        // When
        val result = repository.getAllAlbums()

        // Then
        assertTrue(result.isEmpty())
    }

    @Test
    fun `getAllAlbums should return list of albums when api returns non-null response`() = runTest {
        // Given
        val albums = listOf(
            AlbumModel(1, "Album 1", "cover1.jpg", "2022-01-01", "", "", "", emptyList()),
            AlbumModel(2, "Album 2", "cover2.jpg", "2022-02-01", "", "", "", emptyList())
        )
        whenever(mockService.getAlbums()).thenReturn(albums)

        // When
        val result = repository.getAllAlbums()

        // Then
        assertEquals(albums, result)
    }

    @Test
    fun `getAlbumById should return default album when api returns null`() = runTest {
        // Given
        val id = 1
        val defaultAlbum = AlbumModel(0, "", "", "", "", "", "", emptyList())
        whenever(mockService.getAlbumById(id)).thenReturn(defaultAlbum)

        // When
        val result = repository.getAlbumById(id)

        // Then
        assertEquals(defaultAlbum, result)
    }

    @Test
    fun `getAlbumById should return album when api returns non-null response`() = runTest {
        // Given
        val id = 1
        val album = AlbumModel(1, "Album 1", "cover1.jpg", "2022-01-01", "", "", "", emptyList())
        whenever(mockService.getAlbumById(id)).thenReturn(album)

        // When
        val result = repository.getAlbumById(id)

        // Then
        assertEquals(album, result)
    }
}

