package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "lesson",
    foreignKeys = [
        ForeignKey(
            entity = Course::class,
            parentColumns = ["course_id"],
            childColumns = ["course_idi"]
        )
    ]
)
data class Lesson(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var lesson_name:String,
    var course_idi:Int,
    var lesson_time:String,
    var raqami:String
)
