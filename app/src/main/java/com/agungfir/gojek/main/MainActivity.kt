package com.agungfir.gojek.main

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.agungfir.gojek.R
import com.agungfir.gojek.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewPager()
        initTabs()

    }

    private fun initViewPager() {
        binding.vpMain.apply {
            adapter = MainViewPagerAdapter(supportFragmentManager)
            pageMargin = 8
            currentItem = 1
        }
        binding.tabMain.setupWithViewPager(binding.vpMain)
    }

    private fun initTabs() {
        binding.tabMain.apply {
            getTabAt(0)?.apply {
                text = getString(R.string.promo)
                icon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_discount)

            }
            getTabAt(1)?.apply {
                text = getString(R.string.home)
                icon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_home)
            }
            getTabAt(2)?.apply {
                text = getString(R.string.chat)
                icon = ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_chat)
            }
        }

        val tab = binding.tabMain.getTabAt(2)
        val badge = tab?.orCreateBadge
        badge?.number = 10
        badge?.backgroundColor = Color.parseColor("#F02A2A")

    }
    fun onStateChanged(state: Int) {
        if (state != BottomSheetBehavior.STATE_COLLAPSED) {
            binding.vpMain.bringToFront()
        } else {
            binding.appBarMain.bringToFront()
        }
    }

}