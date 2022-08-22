package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class TablayoutPagerNewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_pager_new)

        val tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        val viewPager=findViewById<ViewPager2>(R.id.viewPager2)

        tabLayout.addTab(tabLayout.newTab().setText("첫번째"))
        tabLayout.addTab(tabLayout.newTab().setText("두번째"))
        tabLayout.addTab(tabLayout.newTab().setText("세번째"))

        viewPager.adapter=FragmentAdapter(this,3)

        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("xxx","unselected")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("xxx","reselected")
            }
        })
    }
}

class FragmentAdapter(
    val fragmentActivity: FragmentActivity,
    val tabCount:Int
): FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        when(position){
            0->return FragmentFirst()
            1->return FragmentSecond()
            else->return FragmentFirst()
        }
    }
}