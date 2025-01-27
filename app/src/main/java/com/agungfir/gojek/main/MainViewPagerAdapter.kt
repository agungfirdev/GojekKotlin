package com.agungfir.gojek.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.agungfir.gojek.main.fragment.chat.ChatFragment
import com.agungfir.gojek.main.fragment.home.HomeFragment
import com.agungfir.gojek.main.fragment.promo.PromoFragment

class MainViewPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = 3
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                PromoFragment()
            }
            1 -> {
                HomeFragment()
            }
            2 -> {
                ChatFragment()
            }
            else -> {
                HomeFragment()
            }
        }
    }
}