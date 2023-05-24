package com.example.elera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.elera.DataClasses.CategoryEnum
import com.example.elera.Fragments.SplashFragment
import com.example.elera.database.AppDatabase
import com.example.elera.database.entity.Course
import com.example.elera.database.entity.Mentors
import com.example.elera.databinding.ActivityMainBinding
import com.example.marks.entity.Student

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appDataBase = AppDatabase.getInstance(this)
//        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.user))
//        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.user))
//        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.user))
//        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.user))
//        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.user))
//        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.user))

        appDataBase.getUserDao().addCourse(Course(course_name = "3D Design Illustration", mentor = 1, student = 1, course_price = "Free", course_reyting = "4.8", category = CategoryEnum.ThreeDDESIGN, image = R.drawable.background_for_3d_design))
//        appDataBase.getUserDao().addCourse(Course(course_name = "3D Design Illustration", mentor = 2, student = 0, course_price = "Free", course_reyting = "4.8", category = CategoryEnum.ThreeDDESIGN, image = R.drawable.background_for_3d_design))
//        appDataBase.getUserDao().addCourse(Course(course_name = "3D Design Illustration", mentor = 2, student = 0, course_price = "Free", course_reyting = "4.8", category = CategoryEnum.ThreeDDESIGN, image = R.drawable.background_for_3d_design))
//        appDataBase.getUserDao().addCourse(Course(course_name = "3D Design Illustration", mentor = 2, student = 0, course_price = "Free", course_reyting = "4.8", category = CategoryEnum.ThreeDDESIGN, image = R.drawable.background_for_3d_design))
//        appDataBase.getUserDao().addCourse(Course(course_name = "3D Design Illustration", mentor = 2, student = 0, course_price = "Free", course_reyting = "4.8", category = CategoryEnum.ThreeDDESIGN, image = R.drawable.background_for_3d_design))

//        appDataBase.getUserDao().addStudent(Student(email = "emailtakhirovshamsiddin@gmail.com", password_student = "Parol_123", code = "1234", date = "12062006", nickname = "Shamsiddin12", name_student = "Tohirov Shamsiddin"))
        supportFragmentManager.beginTransaction().add(R.id.activitymain, SplashFragment()).commit()
    }
}