package com.miu.foodiepal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecipeCardViewAdapter(var rList: ArrayList<Recipe>) :  RecyclerView.Adapter<RecipeCardViewAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeCardViewAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.recipe_card, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeCardViewAdapter.MyViewHolder, position: Int) {
        val constraintLayout = holder.itemView.findViewById<ConstraintLayout>(R.id.playout)
        constraintLayout.apply {
            val name = findViewById<TextView>(R.id.textRecipeName)
            val ingredients = findViewById<TextView>(R.id.textRecipeIngredients)
            val instructions = findViewById<TextView>(R.id.textRecipeInstructions)
            name.text = rList[position].name
            ingredients.text = rList[position].ingredients
            instructions.text = rList[position]. instructions
        }
    }

    override fun getItemCount(): Int {
        return rList.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}