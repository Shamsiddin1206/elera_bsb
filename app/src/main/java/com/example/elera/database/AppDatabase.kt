package com.example.elera.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.elera.database.dao.User
import com.example.elera.database.entity.CompletedLessons
import com.example.elera.database.entity.Course
import com.example.elera.database.entity.Lesson
import com.example.elera.database.entity.Mentors
import com.example.marks.entity.Student


@Database(entities = [Student::class, Mentors::class, Course::class, Lesson::class, CompletedLessons::class], version = 2)
abstract class AppDatabase:RoomDatabase() {
    abstract fun getUserDao(): User

    companion object{
        var instance:AppDatabase? = null
        fun getInstance(context:Context):AppDatabase{
            if(instance == null){
                instance = Room.databaseBuilder(context,AppDatabase::class.java,"app_db")
                    .allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}