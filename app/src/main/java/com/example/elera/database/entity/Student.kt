package com.example.marks.entity

import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "students")
data class Student(
    @PrimaryKey(autoGenerate = true)
    var id_student :Int = 0,
    var password_student:String,
    var email:String?,
    var code:String,
    var date:String?,
    var nickname: String?,
    var name_student :String):Serializable