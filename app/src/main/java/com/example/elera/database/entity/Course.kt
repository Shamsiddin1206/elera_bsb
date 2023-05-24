package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.elera.DataClasses.CategoryEnum
import com.example.marks.entity.Student

@Entity(tableName = "course",
    foreignKeys = [
        ForeignKey(
            entity = Mentors::class,
            parentColumns = ["mentors_id"],
            childColumns = ["mentor"]
        ),
        ForeignKey(
            entity = Student::class,
            parentColumns = ["id_student"],
            childColumns = ["student"]
        )
    ]
)
data class Course(
    @PrimaryKey(autoGenerate = true)
    var course_id:Int = 0,
    var course_name: String,
    var mentor: Int,
    var student:Int,
    var course_price:String,
    var course_reyting:String,
    var category: CategoryEnum,
    var image:Int
):java.io.Serializable