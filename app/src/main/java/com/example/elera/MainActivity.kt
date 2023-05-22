package com.example.elera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.elera.Fragments.SplashFragment
import com.example.elera.database.AppDatabase
import com.example.elera.database.entity.Mentors
import com.example.elera.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val appDataBase = AppDatabase.getInstance(this)
        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.img))
        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.img))
        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.img))
        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.img))
        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.img))
        appDataBase.getUserDao().addMentor(Mentors(firstName = "Jonathan", secondName = "Williams", picture = R.drawable.img))
        supportFragmentManager.beginTransaction().add(R.id.activitymain, SplashFragment()).commit()
    }
}