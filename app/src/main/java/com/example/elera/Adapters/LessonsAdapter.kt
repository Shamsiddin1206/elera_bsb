package com.example.elera.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elera.R
import com.example.elera.database.AppDatabase
import com.example.elera.database.entity.Lesson

class LessonsAdapter(var arrayList: ArrayList<Lesson>, var context: Context, var play: Play): RecyclerView.Adapter<LessonsAdapter.MyHolder>() {
    val appDatabase: AppDatabase by lazy {
        AppDatabase.getInstance(context)
    }
    class MyHolder(view: View):RecyclerView.ViewHolder(view) {
        val name = view.findViewById<TextView>(R.id.lesson_namee)
        val duration = view.findViewById<TextView>(R.id.lesson_duration)
        val number = view.findViewById<TextView>(R.id.lesson_number)
        val status = view.findViewById<ImageView>(R.id.lesson_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val myholder = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.lesson_item, parent, false))
        return myholder
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val a = arrayList[position]
        holder.name.text = a.lesson_name
        holder.duration.text = a.lesson_time
        holder.number.text = a.raqami
        if (appDatabase.getUserDao().getCompleteLessonsById(a.id)==a){
            holder.status.setImageResource(R.drawable.ic_done)
        }else{
            holder.status.setImageResource(R.drawable.ic_play)
        }
    }

    interface Play{
        fun onPlay(lesson: Lesson)
    }
}