package com.example.elera.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elera.R
import com.example.marks.entity.Student

class PersonAdapter(var list: List<Student>): RecyclerView.Adapter<PersonAdapter.MyHolder>() {
    class MyHolder(view: View):RecyclerView.ViewHolder(view) {
        var rasmi:ImageView = view.findViewById(R.id.person_item_image)
        var ismi:TextView = view.findViewById(R.id.person_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val myholder = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false))
        return myholder
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val a = list[position]
        if (a.image != null){
            holder.rasmi.setImageResource(a.image!!)
        }else{
//            holder.rasmi.setImageResource()
        }
    }
}