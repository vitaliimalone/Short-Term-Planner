package com.vitaliimalone.simpletodo.data.repository.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.vitaliimalone.simpletodo.data.repository.local.models.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM noteentity WHERE isArchived = 0")
    suspend fun getAllNotes(): List<NoteEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(noteEntity: NoteEntity)

    @Update
    suspend fun updateNote(note: NoteEntity)
}