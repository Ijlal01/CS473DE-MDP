package edu.miu.ijlal.foodiepal.meal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.miu.ijlal.foodiepal.R

class MealPlannerFragment : Fragment() {

    private lateinit var mealsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal_planner, container, false)

        mealsRecyclerView = view.findViewById(R.id.mealsRecyclerView)

        setupRecyclerView()

        return view
    }

    private fun setupRecyclerView() {
        val meals = getDummyMeals() // Replace with your actual data source
        val adapter = MealsAdapter(meals)
        mealsRecyclerView.layoutManager = LinearLayoutManager(context)
        mealsRecyclerView.adapter = adapter
    }

    private fun getDummyMeals(): List<Meal> {
        // Replace with actual data retrieval logic or use hardcoded data for testing
        return listOf(
            Meal("Monday", "Breakfast: Oatmeal"),
            Meal("Monday", "Lunch: Salad"),
            Meal("Tuesday", "Dinner: Grilled Chicken"),
            // Add more meals as needed
        )
    }
}
