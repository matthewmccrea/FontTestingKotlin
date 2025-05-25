package ar.edu.ort.testingapp
import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.HiltAndroidApp
import ar.edu.ort.testingapp.core.Config


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "setting"
)

@HiltAndroidApp
class TestingApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        Config.baseUrl = "https://api.api-ninjas.com/"
        Config.apiKey = "xx3cfkDq9sg1SrqB0GVvEw==XYpz5Fo2rnsHz1xB"
    }
}