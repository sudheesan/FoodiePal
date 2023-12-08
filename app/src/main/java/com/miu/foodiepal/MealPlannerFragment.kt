package com.miu.foodiepal

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.foodiepal.databinding.FragmentMealPlannerBinding
import java.util.Calendar

class MealPlannerFragment : Fragment() {
    private lateinit var binding: FragmentMealPlannerBinding
    lateinit var mealPlans: ArrayList<MealPlan>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_meal_planner, container, false)
        binding = FragmentMealPlannerBinding.bind(view)

        mealPlans = arrayListOf(
            MealPlan("tomorrow", "breakfast", "bread and butter"),
            MealPlan("tomorrow", "lunch", "rice and curry"),
            MealPlan("tomorrow", "dinner", "pizza"),
            MealPlan("today", "breakfast", "bread and butter"),
            MealPlan("today", "lunch", "rice and curry"),
            MealPlan("today", "dinner", "pizza")
        )

        val mealPlannerCardViewAdapter = MealPlannerCardViewAdapter(mealPlans)
        binding.rvMealPlanner.adapter = mealPlannerCardViewAdapter
        binding.rvMealPlanner.layoutManager = LinearLayoutManager(requireContext())

        binding.buttonAddMealPlanner.setOnClickListener {

            val inflater = LayoutInflater.from(context)
            val dialogView = inflater.inflate(R.layout.new_meal_plan, null)

            // Create the AlertDialog
            val builder = AlertDialog.Builder(context)
            builder.setView(dialogView)
            val alertDialog = builder.create()

            // Show the dialog
            alertDialog.show()

            val closeButton = dialogView.findViewById<Button>(R.id.buttonNewMealClose)
            val submitButton = dialogView.findViewById<Button>(R.id.buttonNewMealSubmit)
            val dateButton = dialogView.findViewById<ImageButton>(R.id.buttonNewMealDate)
            val dateText = dialogView.findViewById<TextView>(R.id.textNewMealDate)
            val meal = dialogView.findViewById<TextView>(R.id.textNewMealFood)
            val spinner = dialogView.findViewById<Spinner>(R.id.spinnerNewMeal)



            dateButton.setOnClickListener {
                val c = Calendar.getInstance();
                val myear = c.get(Calendar.YEAR)
                val mmonth = c.get(Calendar.MONTH)
                val mdate = c.get(Calendar.DAY_OF_MONTH)

                val dpd = DatePickerDialog(
                    requireContext(),
                    DatePickerDialog.OnDateSetListener { view, year, monthofTheYear, dayOfMonth ->
                        dateText.text = "${dayOfMonth}/${monthofTheYear + 1}/${year}"
                    },
                    myear,
                    mmonth,
                    mdate
                )

                dpd.show()
            }

            //Set click listener for the submit button
            submitButton.setOnClickListener {
                // Get the values from the EditText views
                val selectedPosition = spinner.selectedItemPosition
                val mealTime = resources.getStringArray(R.array.meal_times)[selectedPosition]
                val date = dateText.text.toString()
                val food = meal.text.toString()

                if (mealTime.isNotEmpty() && date.isNotEmpty() && food.isNotEmpty()) {
                    mealPlans.add(MealPlan(date, mealTime, food))
                    mealPlannerCardViewAdapter?.notifyDataSetChanged()
                    alertDialog.dismiss()
                } else {
                    Toast.makeText(requireContext(), "Please fill in the fields", Toast.LENGTH_LONG)
                        .show()
                }

            }

            closeButton.setOnClickListener {
                alertDialog.dismiss()
            }
        }

        return view;
    }
}