package com.example.elera.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.elera.R
import com.example.elera.database.entity.Course

class CoursesAdapter(var arrayList: ArrayList<Course>, var context: Context, var onPressed: OnPressed): RecyclerView.Adapter<CoursesAdapter.MyHolder>() {
    inner class MyHolder(itemview: View):RecyclerView.ViewHolder(itemview) {
        val image: ImageView = itemview.findViewById(R.id.home_course_item_image)
        val category: TextView = itemview.findViewById(R.id.home_course_item_category)
        val namE: TextView = itemview.findViewById(R.id.home_course_item_name)
        val price: TextView = itemview.findViewById(R.id.course_detail_price)
        val rating: TextView = itemview.findViewById(R.id.course_detail_rating)
        val card: CardView = itemview.findViewById(R.id.maincard)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val myholder = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.home_course_item, parent, false))
        return myholder
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val a = arrayList[position]
        holder.image.load(a.image)
        holder.category.text = a.category.namE
        holder.namE.text = a.course_name
        holder.price.text = a.course_price
        holder.rating.text = a.course_reyting
        holder.card.setOnClickListener {
            onPressed.onPressed(a)
        }
    }

    interface OnPressed{
        fun onPressed(course: Course)
    }
}