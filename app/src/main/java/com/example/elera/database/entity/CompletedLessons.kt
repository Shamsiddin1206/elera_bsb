package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "completedLessons")
data class CompletedLessons(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var lesson_id:Int,
    var student_id:Int
)
