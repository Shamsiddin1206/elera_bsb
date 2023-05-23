package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course")
data class Course(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var course_name: String,
    var mentor_id: Int,
    var student_id:Int
)