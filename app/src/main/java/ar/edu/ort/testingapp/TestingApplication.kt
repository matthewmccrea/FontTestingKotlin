package ar.edu.ort.testingapp

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "setting"
)

class TestingApplication: Application() {


}