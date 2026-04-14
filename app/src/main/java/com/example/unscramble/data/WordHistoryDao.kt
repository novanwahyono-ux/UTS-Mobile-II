package com.example.unscramble.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WordHistoryDao {

    @Insert
    suspend fun insertWord(word: WordHistory)

    @Query("SELECT * FROM word_history ORDER BY timestamp DESC")
    suspend fun getAllWords(): List<WordHistory>
}