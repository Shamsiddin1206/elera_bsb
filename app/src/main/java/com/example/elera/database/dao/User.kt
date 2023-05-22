package com.example.elera.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.elera.database.entity.Mentors
import com.example.marks.entity.Student

@Dao
interface User {
    @Insert
    fun addStudent(student: Student)

    @Update(entity = Student::class)
    fun updateStudent(student: Student)

    @Query("select * from student")
    fun getAllStudents(): List<Student>

    @Query("select * from Mentors")
    fun getAllMentors():List<Mentors>

    @Insert
    fun addMentor(mentors: Mentors)

}