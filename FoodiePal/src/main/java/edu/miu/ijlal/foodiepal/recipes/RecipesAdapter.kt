package edu.miu.ijlal.foodiepal.recipes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import edu.miu.ijlal.foodiepal.R

class RecipesAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val recipeNameTextView: TextView = itemView.findViewById(R.id.recipeNameTextView)
        private val cookingTimeTextView: TextView = itemView.findViewById(R.id.cookingTimeTextView)
        private val instructionsTextView: TextView = itemView.findViewById(R.id.instructionsTextView)

        fun bind(recipe: Recipe) {
            recipeNameTextView.text = recipe.name
            cookingTimeTextView.text = recipe.rec
            instructionsTextView.text = recipe.inc
        }
    }
}
