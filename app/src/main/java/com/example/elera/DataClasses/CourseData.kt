package com.example.elera.DataClasses

import com.example.elera.database.entity.Mentors

data class CourseData(
    var name:String,
    var category: CategoryEnum,
    var image:String,
    var prices:ArrayList<Int>,
    var durationHour: Int,
    var durationMin: Int,
    var hasCertificate:Boolean,
    var mentor: Mentors,
    var about:String):java.io.Serializable