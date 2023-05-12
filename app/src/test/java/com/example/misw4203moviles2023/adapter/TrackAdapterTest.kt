import android.content.Context
import android.widget.FrameLayout
import androidx.test.core.app.ApplicationProvider
import com.example.misw4203moviles2023.adapter.TrackAdapter
import com.example.misw4203moviles2023.adapter.OnItemClickListener
import com.example.misw4203moviles2023.data.model.TrackModel
import com.example.misw4203moviles2023.test.TestApplication
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(application= TestApplication::class)
@RunWith(RobolectricTestRunner::class)
class TrackAdapterTest {

    private lateinit var adapter: TrackAdapter
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        val trackList = listOf(
            mockTrackModel(
                1,
                "Track 1",
                "3:00"
            ),
            mockTrackModel(
                2,
                "Track 2",
                "4:00"
            )
        )
        adapter = TrackAdapter(trackList)
    }

    @Test
    fun onCreateViewHolder_inflatesTrackRowBinding() {
        val parent = FrameLayout(context)
        val viewHolder = adapter.onCreateViewHolder(parent, 0)

        assertThat(viewHolder, instanceOf(TrackAdapter.TrackViewHolder::class.java))
    }

    @Test
    fun getItemCount_returnsTrackListSize() {
        assertEquals(adapter.itemCount, 2)
    }
}


