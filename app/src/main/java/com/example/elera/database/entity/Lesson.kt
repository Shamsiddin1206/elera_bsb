package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson")
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var lesson_name:String,
    var course_id:String
)
