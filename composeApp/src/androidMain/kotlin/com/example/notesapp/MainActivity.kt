package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val db = androidx.room.Room.databaseBuilder<com.example.notesapp.data.AppDatabase>(
            context = applicationContext,
            name = applicationContext.getDatabasePath("notes.db").absolutePath
        ).setDriver(androidx.sqlite.driver.bundled.BundledSQLiteDriver())
         .setQueryCoroutineContext(kotlinx.coroutines.Dispatchers.IO)
         .build()

        setContent {
            App(db.noteDao())
        }
    }
}
