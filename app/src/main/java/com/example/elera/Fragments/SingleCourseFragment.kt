package com.example.elera.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elera.API
import com.example.elera.Adapters.LessonsAdapter
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.database.entity.CompletedLessons
import com.example.elera.database.entity.Lesson
import com.example.elera.databinding.FragmentSingleCourseBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SingleCourseFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(requireContext())
    }
    lateinit var api: API
    lateinit var lessonsList:ArrayList<Lesson>
    lateinit var completedList: ArrayList<CompletedLessons>
    lateinit var binding: FragmentSingleCourseBinding
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleCourseBinding.inflate(inflater, container, false)
        api = API.newInstance(requireContext())
        lessonsList = appDatabase.getUserDao().getLessonsByCourse(0)
        completedList = appDatabase.getUserDao().getAllCompletedLessons()
        val lessonsAdapter = LessonsAdapter(lessonsList, requireContext(), object : LessonsAdapter.Play{
            override fun onPlay(lesson: Lesson) {
                var count = 0
                for (i in 0 until completedList.size){
                    if (completedList[i].lesson == lesson.id && completedList[i].student == api.getLoggedUser()[0].id_student){
                        count++
                    }
                }
                if (count==0){
                    appDatabase.getUserDao().addToCompletedLessons(CompletedLessons(lesson = lesson.id, student = api.getLoggedUser()[0].id_student))
                }
            }
        })
        lessonsAdapter.notifyDataSetChanged()
        binding.lessonsRecycler.adapter = lessonsAdapter
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SingleCourseFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}