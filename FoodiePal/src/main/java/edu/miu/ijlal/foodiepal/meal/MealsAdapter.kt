package edu.miu.ijlal.foodiepal.meal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.miu.ijlal.foodiepal.R

class MealsAdapter(private val meals: List<Meal>) : RecyclerView.Adapter<MealsAdapter.MealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val meal = meals[position]
        holder.bind(meal)
    }

    override fun getItemCount(): Int {
        return meals.size
    }

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dayTextView: TextView = itemView.findViewById(R.id.dayTextView)
        private val mealNameTextView: TextView = itemView.findViewById(R.id.mealNameTextView)

        fun bind(meal: Meal) {
            dayTextView.text = meal.day
            mealNameTextView.text = meal.mealName
        }
    }
}
