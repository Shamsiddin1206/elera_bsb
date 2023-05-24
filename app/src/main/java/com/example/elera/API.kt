package com.example.elera

import android.content.Context
import com.example.marks.entity.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class API private constructor(context: Context){
    val sharedPreferences = context.getSharedPreferences("data", 0)
    val edit = sharedPreferences.edit()
    val gson = Gson()

    companion object{
        private var instance:API? = null
        fun newInstance(contexT: Context): API {
            if (instance == null){
                instance = API(contexT)
            }
            return instance!!
        }
    }

    fun setLoggedUser(arrayList: ArrayList<Student>){
        edit.putString("Logged", gson.toJson(arrayList)).apply()
    }
    fun getLoggedUser(): ArrayList<Student>{
        val data: String = sharedPreferences.getString("Logged", "")!!
        if (data == ""){
            return arrayListOf()
        }
        val typeToken = object : TypeToken<MutableList<Student>>(){}.type
        return gson.fromJson(data, typeToken)
    }
}