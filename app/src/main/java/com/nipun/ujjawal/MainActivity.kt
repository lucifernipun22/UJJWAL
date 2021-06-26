package com.nipun.ujjawal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.nipun.ujjawal.fragments.BuyersFragment
import com.nipun.ujjawal.fragments.HomeFragment
import com.nipun.ujjawal.fragments.NewsFragment
import com.nipun.ujjawal.fragments.OrderFragment


class MainActivity : AppCompatActivity() {

    var navigationView: BottomNavigationView? = null
    var TIME_LIMIT = 1500
    var backPressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigation = findViewById<MeowBottomNavigation>(R.id.bottomNavigation)
        addFragment(HomeFragment.newInstance())
        bottomNavigation.show(0)
        bottomNavigation.add(
            MeowBottomNavigation.Model(
                0,
                R.drawable.ic_baseline_home_24
            )
        )
        bottomNavigation.add(MeowBottomNavigation.Model(1, R.drawable.ic_baseline_people_alt_24))
        bottomNavigation.add(
            MeowBottomNavigation.Model(
                2,
                R.drawable.ic_iconfinder_2639879_order_icon
            )
        )
        bottomNavigation.add(MeowBottomNavigation.Model(3, R.drawable.ic_news_4301))


        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                0 -> {
                    replaceFragment(HomeFragment.newInstance())

                }
                1 -> {
                    replaceFragment(BuyersFragment.newInstance())

                }
                2 -> {
                    replaceFragment(OrderFragment.newInstance())
                }
                3 -> {
                    replaceFragment(NewsFragment.newInstance())
                }

                else -> {
                    replaceFragment(HomeFragment.newInstance())
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.fragmentContainer, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    private fun addFragment(fragment: Fragment){
        val fragmentTransition = supportFragmentManager.beginTransaction()
        fragmentTransition.add(R.id.fragmentContainer, fragment).addToBackStack(Fragment::class.java.simpleName).commit()
    }

    // This method is used to detect back button


}