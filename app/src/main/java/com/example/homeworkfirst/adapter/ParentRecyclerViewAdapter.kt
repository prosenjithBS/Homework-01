package com.example.homeworkfirst.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homeworkfirst.R
import com.example.homeworkfirst.data.MovieDataSource.setUpChildArrayList
import com.example.homeworkfirst.databinding.ParentRecyclerviewItemsBinding
import com.example.homeworkfirst.ui.MovieDetailsFragment
import com.example.nestedrecyclerviewdemo.model.ChildModel
import com.example.nestedrecyclerviewdemo.model.ParentModel


class ParentRecyclerViewAdapter(
        private val parentModelArrayList: ArrayList<ParentModel>,
        private val context: Context
) : RecyclerView.Adapter<ParentRecyclerViewAdapter.MyViewHolder>(){

    inner class MyViewHolder(val binding: ParentRecyclerviewItemsBinding):RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
    val binding = ParentRecyclerviewItemsBinding
        .inflate(LayoutInflater.from(parent.context), parent, false)
    return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        with(holder){
            with(parentModelArrayList[position]){
                binding.ChildRV.layoutManager = layoutManager
                binding.ChildRV.setHasFixedSize(true)
                binding.MovieCategory.text=this.movieCategory
            }
        }
        val arrayList = ArrayList<ChildModel>()
        setUpChildArrayList(arrayList, position)

        val childRecyclerViewAdapter = ChildRecyclerViewAdapter(arrayList){ item ->
            //Toast.makeText(context,"${item.movieName} Clicked",Toast.LENGTH_SHORT).show()
            val manager: FragmentManager = (context as AppCompatActivity).supportFragmentManager
            manager.commit {
                setReorderingAllowed(true)
                val imageView : ImageView = holder.itemView.rootView.findViewById(R.id.hero_image)
                addSharedElement(imageView, ViewCompat.getTransitionName(imageView)!!)
                replace(R.id.fragmentContainerView,MovieDetailsFragment())
                addToBackStack("movie_details")
            }
        }
        holder.binding.ChildRV.adapter=childRecyclerViewAdapter

    }

    override fun getItemCount() = parentModelArrayList.size

}