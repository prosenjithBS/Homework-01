package com.example.homeworkfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.homeworkfirst.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            val nestedRVCollapsingTBFragment=NestedRVCollapsingTBFragment()
            setReorderingAllowed(true)
            add(R.id.fragmentContainerView,nestedRVCollapsingTBFragment)
            //addToBackStack("all_movies")
        }
    }
}