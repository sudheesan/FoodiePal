package com.miu.foodiepal

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.foodiepal.databinding.ActivityMainBinding
import com.miu.foodiepal.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment() {
    private lateinit var binding: FragmentRecipesBinding
    lateinit var recipes: ArrayList<Recipe>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_recipes, container, false)
        binding = FragmentRecipesBinding.bind(view)

        recipes = arrayListOf(
            Recipe("Pizza", "Cheese, tomato sauce", "bake"),
            Recipe("Burger", "Patty, tomato sauce", "Bake"),
            Recipe("Pizza", "Cheese, tomato sauce", "bake"),
            Recipe("Burger", "Patty, tomato sauce", "Bake"),
            Recipe("Burger", "Patty, tomato sauce", "Bake")
        )

        val recipeCrdViewAdapter = RecipeCardViewAdapter(recipes);

        binding.rv.adapter = recipeCrdViewAdapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        binding.buttonAddRecipe.setOnClickListener{

            val inflater = LayoutInflater.from(context)
            val dialogView = inflater.inflate(R.layout.new_recipe, null)

            // Create the AlertDialog
            val builder = AlertDialog.Builder(context)
            builder.setView(dialogView)
            val alertDialog = builder.create()

            // Show the dialog
            alertDialog.show()

            val closeButton = dialogView.findViewById<Button>(R.id.buttonNewRecipeClose)
            val submitButton = dialogView.findViewById<Button>(R.id.buttonNewRecipeSubmit)
            val nameEditText = dialogView.findViewById<EditText>(R.id.textNewRecipename)
            val ingredientsEditText = dialogView.findViewById<EditText>(R.id.textNewRecipeIngredents)
            val instructionsEditText = dialogView.findViewById<EditText>(R.id.textNewRecipeInstructions)


            // Set click listener for the submit button
            submitButton.setOnClickListener {
                // Get the values from the EditText views
                val name = nameEditText.text.toString()
                val ingredients = ingredientsEditText.text.toString()
                val instructions = instructionsEditText.text.toString()

                val recipe = Recipe(name, ingredients, instructions)

                recipes.add(recipe)

                recipeCrdViewAdapter?.notifyDataSetChanged()
                alertDialog.dismiss()
            }

            closeButton.setOnClickListener {
                alertDialog.dismiss()
            }
        }

        return view
    }



}