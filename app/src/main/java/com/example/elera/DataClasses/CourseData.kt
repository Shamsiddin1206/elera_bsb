package com.example.elera.DataClasses

data class CourseData(
    var name:String,
    var category: CategoryEnum,
    var image:String,
    var prices:ArrayList<Int>,
    var durationHour: Int,
    var durationMin: Int,
    var hasCertificate:Boolean,
    var mentor: MentorData,
    var about:String):java.io.Serializable