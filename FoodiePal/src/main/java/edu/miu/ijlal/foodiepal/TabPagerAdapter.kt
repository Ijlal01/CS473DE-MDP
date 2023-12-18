package edu.miu.ijlal.foodiepal

import BlogFragment
import edu.miu.ijlal.foodiepal.recipes.RecipesFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import edu.miu.ijlal.foodiepal.about.AboutMeFragment
import edu.miu.ijlal.foodiepal.contact.ContactFragment
import edu.miu.ijlal.foodiepal.meal.MealPlannerFragment

class TabPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RecipesFragment()
            1 -> MealPlannerFragment()
            2 -> BlogFragment()
            3 -> ContactFragment()
            4 -> AboutMeFragment()
            else -> RecipesFragment()
        }
    }

    override fun getCount(): Int {
        return 5 // Number of tabs
    }

    override fun getPageTitle(position: Int): CharSequence? {
        // Return tab titles
        return when (position) {
            0 -> "Recipes"
            1 -> "Meal Planner"
            2 -> "Blog"
            3 -> "Contact"
            4 -> "About Me"
            else -> null
        }
    }
}
