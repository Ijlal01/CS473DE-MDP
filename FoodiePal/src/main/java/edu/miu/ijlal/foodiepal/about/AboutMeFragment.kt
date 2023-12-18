package edu.miu.ijlal.foodiepal.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import edu.miu.ijlal.foodiepal.R

class AboutMeFragment : Fragment() {

    private lateinit var addDetailsFab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about_me, container, false)

        addDetailsFab = view.findViewById(R.id.addDetailsFab)

        setupClickListeners()

        return view
    }

    private fun setupClickListeners() {
        addDetailsFab.setOnClickListener {
            // Handle FloatingActionButton click (add new details)
            // Implement your logic for adding new details dynamically
        }
    }
}
