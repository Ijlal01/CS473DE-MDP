package edu.miu.ijlal.foodiepal

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Check authentication status
        val sharedPreferences = getSharedPreferences("FoodiePalPreferences", Context.MODE_PRIVATE)
        val isAuthenticated = sharedPreferences.getBoolean("authenticated", false)

        if (!isAuthenticated) {
            // Redirect to authentication screen
            // Implement authentication logic here
        }

        // Setup TabLayout with Fragments
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val adapter = TabPagerAdapter(supportFragmentManager)
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
