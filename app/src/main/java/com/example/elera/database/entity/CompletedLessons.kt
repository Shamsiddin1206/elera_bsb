package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.marks.entity.Student

@Entity(tableName = "completedLessons",
    foreignKeys = [
        ForeignKey(
            entity = Lesson::class,
            parentColumns = ["lesson_id"],
            childColumns = ["lesson"]
        ),
        ForeignKey(
            entity = Student::class,
            parentColumns = ["student_id"],
            childColumns = ["student"]
        )
    ]
)
data class CompletedLessons(
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0,
    var lesson:Int,
    var student:Int
)
