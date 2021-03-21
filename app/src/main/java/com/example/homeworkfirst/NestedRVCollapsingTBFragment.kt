package com.example.homeworkfirst

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.example.homeworkfirst.adapter.ParentRecyclerViewAdapter
import com.example.homeworkfirst.data.MovieDataSource
import com.example.homeworkfirst.databinding.FragmentNestedRvColTbBinding
import com.example.nestedrecyclerviewdemo.model.ParentModel


class NestedRVCollapsingTBFragment: Fragment() {

    private lateinit var binding:FragmentNestedRvColTbBinding
    private lateinit var parentRecyclerView: RecyclerView
    private lateinit var parentAdapter: ParentRecyclerViewAdapter
    private lateinit var parentModelArrayList:ArrayList<ParentModel>
    private lateinit var parentLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = TransitionInflater.from(requireContext())
        exitTransition = inflater.inflateTransition(R.transition.fade)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNestedRvColTbBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpCollapsingToolbar()
        parentModelArrayList = MovieDataSource.parentModelArrayList
        setUpRecyclerView()
    }

    private fun setUpCollapsingToolbar(){
        (activity as AppCompatActivity?)!!.setSupportActionBar(binding.toolbar)
        binding.collapsingToolbarLayout.title="Title"
        binding.collapsingToolbarLayout.setContentScrimColor(Color.BLACK)
    }
    private fun setUpRecyclerView(){
        parentRecyclerView=binding.ParentRecyclerView
        parentRecyclerView.setHasFixedSize(true)
        parentLayoutManager = LinearLayoutManager(activity)
        parentAdapter = context?.let { ParentRecyclerViewAdapter(parentModelArrayList, it) }!!
        parentRecyclerView.layoutManager = parentLayoutManager
        parentRecyclerView.adapter = parentAdapter
        parentAdapter.notifyDataSetChanged()
    }
}