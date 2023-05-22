package com.example.elera.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.marks.entity.Student

@Dao
interface User {
    @Insert
    fun addStudent(student: Student)

    @Update(entity = Student::class)
    fun updateStudent(student: Student)

    @Query("select * from student")
    fun getAllStudents(): List<Student>

}