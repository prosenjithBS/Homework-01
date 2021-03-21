package com.example.homeworkfirst.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfirst.R
import com.example.nestedrecyclerviewdemo.model.ChildModel


class ChildRecyclerViewAdapter(
    private val childModelArrayList:ArrayList<ChildModel>,
    private val onItemClicked:(ChildModel) -> Unit
) : RecyclerView.Adapter<ChildRecyclerViewAdapter.MyViewHolder>(){

    inner class MyViewHolder(
            itemView: View,
            private val onItemClicked: (ChildModel) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                onItemClicked( childModelArrayList[adapterPosition])
            }
        }
        var heroImage: ImageView =itemView.findViewById(R.id.hero_image)
        var movieName: TextView = itemView.findViewById(R.id.movie_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.child_recyclerview_items, parent, false)
        return MyViewHolder(view){
            onItemClicked(it)
        }
    }

    override fun getItemCount() = childModelArrayList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = childModelArrayList[position]
        holder.heroImage.setImageResource(currentItem.hero_image)
        holder.movieName.text=currentItem.movieName
    }
}