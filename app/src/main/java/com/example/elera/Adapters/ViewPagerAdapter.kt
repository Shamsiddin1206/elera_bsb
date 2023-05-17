package com.example.elera.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.elera.DataClasses.ViewPagerData
import com.example.elera.R

class ViewPagerAdapter(private val item:MutableList<ViewPagerData>): RecyclerView.Adapter<ViewPagerAdapter.MyHolder>() {
    class MyHolder(view: View):RecyclerView.ViewHolder(view) {
        private val photo = view.findViewById<ImageView>(R.id.viewpager_rasm)
        private val text = view.findViewById<TextView>(R.id.viewpager_text)
        fun info(viewPagerData: ViewPagerData){
            photo.setImageResource(viewPagerData.main_photo)
            text.text = viewPagerData.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.viewpager_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.info(item[position])
    }
}