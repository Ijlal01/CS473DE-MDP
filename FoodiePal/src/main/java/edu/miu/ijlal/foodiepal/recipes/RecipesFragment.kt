package edu.miu.ijlal.foodiepal.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.miu.ijlal.foodiepal.R

class RecipesFragment : Fragment() {

    private lateinit var recipesRecyclerView: RecyclerView
    private lateinit var addRecipeFab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        recipesRecyclerView = view.findViewById(R.id.recipesRecyclerView)
        addRecipeFab = view.findViewById(R.id.addRecipeFab)

        setupRecyclerView()

        addRecipeFab.setOnClickListener {

        }

        return view
    }

    private fun setupRecyclerView() {
        val recipes = getDummyRecipes()
        val adapter = RecipesAdapter(recipes)
        recipesRecyclerView.layoutManager = LinearLayoutManager(context)
        recipesRecyclerView.adapter = adapter
    }

    private fun getDummyRecipes(): List<Recipe> {
        return listOf(
            Recipe("Pasta Carbonara", "Pasta \n Eggs \n Bacon", "instructions..."),
            Recipe("Pizza 2", "Pizza dough \n Tomato sauce \n Mozzarella", "instructions..."),
            Recipe("Recipe 3", "Recipe", "instructions..."),
        )
    }
}
