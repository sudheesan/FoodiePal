package com.miu.foodiepal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class PageFragmentAdapter(fm: FragmentManager, lc:Lifecycle): FragmentStateAdapter(fm, lc) {
    override fun getItemCount() = 5
    override fun createFragment(position: Int): Fragment {
       return when(position){
            0 -> RecipesFragment()
            1 -> MealPlannerFragment()
            2 -> BlogFragment()
            3 -> ContactFragment()
            4 -> AboutMeFragment()
            else -> Fragment()
        }
    }
}