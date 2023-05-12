import android.os.Bundle
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.misw4203moviles2023.ui.view.AlbumDetailArgs
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumDetailArgsTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `toBundle should return correct bundle`() {
        // Arrange
        val albumId = 123
        val args = AlbumDetailArgs(albumId)

        // Act
        val result = args.toBundle()

        // Assert
        assertEquals(albumId, result.getInt("albumId"))
    }

    @Test
    fun `toSavedStateHandle should return correct saved state handle`() {
        // Arrange
        val albumId = 123
        val args = AlbumDetailArgs(albumId)

        // Act
        val result = args.toSavedStateHandle()

        // Assert
        assertEquals(albumId, result.get<Int>("albumId"))
    }

    @Test
    fun `fromBundle should return correct AlbumDetailArgs`() {
        // Arrange
        val bundle = Bundle().apply {
            putInt("albumId", 123)
        }

        // Act
        val result = AlbumDetailArgs.fromBundle(bundle)

        // Assert
        assertEquals(123, result.albumId)
    }

    @Test
    fun `fromSavedStateHandle should return correct AlbumDetailArgs`() {
        // Arrange
        val savedStateHandle = SavedStateHandle().apply {
            set("albumId", 123)
        }

        // Act
        val result = AlbumDetailArgs.fromSavedStateHandle(savedStateHandle)

        // Assert
        assertEquals(123, result.albumId)
    }

    @Test
    fun `fromSavedStateHandle should throw IllegalArgumentException if albumId is null`() {
        // Arrange
        val savedStateHandle = SavedStateHandle().apply {
            set<Int?>("albumId", null)
        }

        // Act & Assert
        assertThrows(IllegalArgumentException::class.java) {
            AlbumDetailArgs.fromSavedStateHandle(savedStateHandle)
        }
    }
}
