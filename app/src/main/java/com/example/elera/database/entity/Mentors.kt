package com.example.elera.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mentors(
    @PrimaryKey(autoGenerate = true)
    var mentors_id:Int = 0,
    var firstName:String,
    var secondName:String,
    var picture:Int
):java.io.Serializable
