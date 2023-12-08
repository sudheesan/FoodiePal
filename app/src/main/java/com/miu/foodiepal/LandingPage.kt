package com.miu.foodiepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.miu.foodiepal.databinding.ActivityLandingPageBinding

class LandingPage : AppCompatActivity() {
    private lateinit var binding: ActivityLandingPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        val adapter = PageFragmentAdapter(supportFragmentManager, lifecycle)

        binding.pager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.pager) {tab, position ->
            when(position){
                0 -> {
                    tab.text = "Recipes"
                }
                1 -> {
                    tab.text = "Meal Planner"
                }
                2 -> {
                    tab.text = "Blog"
                }
                3 -> {
                    tab.text = "Contact"
                }
                4 -> {
                    tab.text = "About Me"
                }
            }
        }.attach()

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navRecipes -> {
                    binding.pager.setCurrentItem(0, true)
                    return@setOnItemSelectedListener true
                }
                R.id.navMealPlanner -> {
                    binding.pager.setCurrentItem(1, true)
                    return@setOnItemSelectedListener true
                }
                R.id.navBlog -> {
                    binding.pager.setCurrentItem(2, true)
                    return@setOnItemSelectedListener true
                }
                else -> return@setOnItemSelectedListener false
            }
        }

    }
}