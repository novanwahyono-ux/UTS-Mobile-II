package com.example.unscramble.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.Date
import com.example.unscramble.ui.GameViewModel

@Composable
fun HistoryScreen(
    gameViewModel: GameViewModel = viewModel(),
    onBack: () -> Unit
) {
    val history by gameViewModel.historyList.collectAsState(initial = emptyList())

    Column(modifier = Modifier.fillMaxSize()) {

        //  HEADER
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("History", style = MaterialTheme.typography.titleLarge)

            TextButton(onClick = onBack) {
                Text("Back")
            }
        }

        //  LIST DATA
        LazyColumn {
            items(history) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(12.dp)) {
                        Text("Word: ${item.word}")
                        Text("Time: ${Date(item.timestamp)}")
                    }
                }
            }
        }
    }
}