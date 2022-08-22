package com.example.firstkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class TablayoutPagerSimpleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout_pager_simple)

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        val tabLayout: TabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.addTab(tabLayout.newTab().setText("First"))
        tabLayout.addTab(tabLayout.newTab().setText("Second"))
        tabLayout.addTab(tabLayout.newTab().setText("Third"))

        viewPager.adapter=ViewPagerAdapter(LayoutInflater.from(this), 3)

        tabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("xxx","unselected")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("xxx","selected")
            }
        })
    }
}

class ViewPagerAdapter(
    val layoutInflater: LayoutInflater,
    val tabCount:Int
): PagerAdapter(){
    override fun getCount(): Int {
        return tabCount
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view===`object` as View
    }
    //== 값을 비교
    //=== 메모리 주소값도 동일한지, 즉 동일한 인스턴스인지

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        when(position){
            0->{
                val view:View=layoutInflater.inflate(R.layout.chatitem_right,container,false)
                container.addView(view)
                return view
            }
            1->{
                val view:View=layoutInflater.inflate(R.layout.chatitem_left,container,false)
                container.addView(view)
                return view
            }
            else->{
                val view:View=layoutInflater.inflate(R.layout.address_item,container,false)
                container.addView(view)
                return view
            }
        }
    }
}
