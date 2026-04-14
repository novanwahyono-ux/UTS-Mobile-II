package com.example.unscramble.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_history")
data class WordHistory(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val timestamp: Long = System.currentTimeMillis()
)