package com.example.elera.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.elera.database.entity.CompletedLessons
import com.example.elera.database.entity.Course
import com.example.elera.database.entity.Lesson
import com.example.elera.database.entity.Mentors
import com.example.marks.entity.Student

@Dao
interface User {
    @Insert
    fun addStudent(student: Student)

    @Update(entity = Student::class)
    fun updateStudent(student: Student)

    @Query("select * from students")
    fun getAllStudents(): List<Student>

    @Query("select * from mentors")
    fun getAllMentors():List<Mentors>

    @Insert
    fun addMentor(mentors: Mentors)

    @Query("select * from course")
    fun getAllCourses():List<Course>

    @Insert
    fun addCourse(course: Course)

    @Query("select * from lesson")
    fun getAllLessons():ArrayList<Lesson>

    @Insert
    fun addLesson(lesson: Lesson)

    @Query("select * from completedLessons")
    fun getAllCompletedLessons():ArrayList<CompletedLessons>

    @Query("select * from completedLessons where id = :lesson_id")
    fun getCompleteLessonsById(lesson_id:Int):Lesson

    @Insert
    fun addToCompletedLessons(completedLessons: CompletedLessons)

    @Query("select * from lesson where course_idi = :courseni_id")
    fun getLessonsByCourse(courseni_id:Int): ArrayList<Lesson>
}