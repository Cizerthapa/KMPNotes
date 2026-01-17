package com.example.notesapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notesapp.data.NoteDao


@Composable
fun App(noteDao: NoteDao) {
    MaterialTheme {
        val viewModel = viewModel { NotesViewModel(noteDao) }
        NotesScreen(viewModel)
    }
}