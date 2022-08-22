package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class TablayoutPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_pager)

        val tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        val viewPager=findViewById<ViewPager>(R.id.viewPager)

        tabLayout.addTab(tabLayout.newTab().setText("1'st"))
        tabLayout.addTab(tabLayout.newTab().setText("2'nd"))
        tabLayout.addTab(tabLayout.newTab().setText("3'th").setIcon(R.drawable.khe_works1))

        viewPager.adapter=FragmentPagerAdapter(supportFragmentManager,3)

        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }
        })
    }
}

class FragmentPagerAdapter(
    val fragmentManager: FragmentManager,
    val tabCount:Int
): FragmentStatePagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        when(position){
            0->return FragmentFirst()
            1->return FragmentSecond()
            else->return FragmentFirst()
        }
    }
}