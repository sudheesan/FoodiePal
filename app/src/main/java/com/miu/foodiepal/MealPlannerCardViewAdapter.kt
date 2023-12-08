package com.miu.foodiepal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class MealPlannerCardViewAdapter(var mList:ArrayList<MealPlan>) :  RecyclerView.Adapter<MealPlannerCardViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealPlannerCardViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.meal_planner_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealPlannerCardViewAdapter.MyViewHolder, position: Int) {
        val constraintLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.mealPlannerCardLayout)
        constraintLayout.apply {
            val date = findViewById<TextView>(R.id.textPlannerDate)
            val time = findViewById<TextView>(R.id.textPlannerTime)
            val food = findViewById<TextView>(R.id.textPlannerFood)
            date.text = mList[position].date
            time.text = mList[position].time
            food.text = mList[position]. food
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

