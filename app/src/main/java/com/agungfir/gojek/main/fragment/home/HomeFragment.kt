package com.agungfir.gojek.main.fragment.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.agungfir.gojek.R
import com.agungfir.gojek.databinding.FragmentHomeBinding
import com.agungfir.gojek.main.BalanceAdapter
import com.agungfir.gojek.main.MainActivity
import com.agungfir.gojek.main.floatingslideupsheet.view.FloatingSlideUpBuilder
import com.agungfir.gojek.utils.visible
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle


class HomeFragment : Fragment(), FloatingSlideUpBuilder.OnStateChanged {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initBottomSheetBehavior()
        initView()

        return binding.root
    }

    private fun initBottomSheetBehavior() {
        val behavior = BottomSheetBehavior.from(binding.bottomSheetHome)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED
        behavior.isFitToContents = true

        behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    binding.slideContent.animate().translationY(280F).duration = 200
                } else {
                    binding.slideContent.animate().translationY(0F).duration = 200
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
        })

    }

    private fun updatePagerHeightForChild(view: View, pager: ViewPager2) {
        view.post {
            val wMeasureSpec =
                View.MeasureSpec.makeMeasureSpec(view.width, View.MeasureSpec.EXACTLY)
            val hMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
            view.measure(wMeasureSpec, hMeasureSpec)
            pager.layoutParams = (pager.layoutParams).also { lp ->
                lp.height = view.measuredHeight + view.marginTop + view.marginBottom
            }
            pager.invalidate()

            updateIndicator(view)
        }
    }

    private fun updateIndicator(view: View) {
        binding.includeBottomSheetHome.layoutInfoBalance.indicatorView.apply {
            visible()
            setSliderWidth(view.measuredHeight.div(8).toFloat())
            setIndicatorGap(16F)
            setSliderHeight(8F)
            setSlideMode(IndicatorSlideMode.WORM)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setPageSize(binding.includeBottomSheetHome.layoutInfoBalance.vpMain.adapter!!.itemCount)
            notifyDataChanged()
        }


    }

    @SuppressLint("ResourceAsColor")
    private fun initView() {
        val floatingSlideUpSheet = FloatingSlideUpBuilder(requireContext(), binding.slideContent)
            .setFloatingMenuRadiusInDp(50)
            .setFloatingMenuColor(android.R.color.white)
            .setFloatingMenu(binding.containerFloatingMenu.containerFloatingMenu)
            .setPanel(binding.contentExpandContainer.contentExpandContainer)
            .build()

        floatingSlideUpSheet.setOnStateChanged(this)

        floatingSlideUpSheet.expandBottomSheet()
        floatingSlideUpSheet.collapseBottomSheet()

        binding.includeBottomSheetHome.layoutInfoBalance.tabMain.addTab(
            binding.includeBottomSheetHome.layoutInfoBalance.tabMain.newTab()
                .setText(getString(R.string.pay))
                .setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.pay))
        )
        binding.includeBottomSheetHome.layoutInfoBalance.tabMain.addTab(
            binding.includeBottomSheetHome.layoutInfoBalance.tabMain.newTab()
                .setText(getString(R.string.top_up))
                .setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.top_up))
        )
        binding.includeBottomSheetHome.layoutInfoBalance.tabMain.addTab(
            binding.includeBottomSheetHome.layoutInfoBalance.tabMain.newTab()
                .setText(getString(R.string.explore))
                .setIcon(ContextCompat.getDrawable(requireContext(), R.drawable.explore))
        )


        val tab = binding.includeBottomSheetHome.layoutInfoBalance.tabMain.getTabAt(2)
        val badge = tab?.orCreateBadge
        badge?.number = 4
        badge?.backgroundColor = Color.parseColor("#F02A2A")

        binding.includeBottomSheetHome.layoutInfoBalance.vpMain.apply {
            orientation = ViewPager2.ORIENTATION_VERTICAL
            adapter = BalanceAdapter()
            offscreenPageLimit = 3
            clipToPadding = false
        }


        Handler(requireActivity().mainLooper).postDelayed({
            binding.includeBottomSheetHome.layoutInfoBalance.vpMain.setCurrentItem(1, true)
        }, 6000)

        binding.includeBottomSheetHome.layoutInfoBalance.vpMain.setPageTransformer { page, position ->
            val pageMargin = page.marginTop - 3

            val myOffset = position * -(2 * pageMargin + pageMargin)
            when (position) {
                1F -> {
                    page.apply {
                        scaleY = 0.80F
                        scaleX = 0.80F
                        alpha = 0.6F
                        translationY = myOffset
                    }

                }
                0F -> {
                    page.apply {
                        scaleY = 0.95F
                        scaleX = 0.95F
                        alpha = 1F
                        translationY = 1F
                        translationX = 1F
                    }
                }
                -1F -> {
                    page.apply {
                        scaleY = 0.80F
                        scaleX = 0.80F
                        alpha = 0.6F
                        translationY = myOffset
                    }

                }
                else -> {
                    page.apply {
                        scaleY = 0.9F
                        scaleX = 0.9F
                        alpha = 1F
                    }
                }
            }

            updatePagerHeightForChild(
                page,
                binding.includeBottomSheetHome.layoutInfoBalance.vpMain
            )
        }

        binding.includeBottomSheetHome.layoutInfoBalance.vpMain.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                val behavior = BottomSheetBehavior.from(binding.bottomSheetHome)
                behavior.isDraggable = state != ViewPager2.SCROLL_STATE_DRAGGING
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                binding.includeBottomSheetHome.layoutInfoBalance.indicatorView.onPageScrolled(
                    position,
                    positionOffset,
                    positionOffsetPixels
                )
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.includeBottomSheetHome.layoutInfoBalance.indicatorView.onPageSelected(
                    position
                )
            }
        })


    }

    override fun onStateChanged(state: Int) {
        (activity as MainActivity).onStateChanged(state)
    }

}