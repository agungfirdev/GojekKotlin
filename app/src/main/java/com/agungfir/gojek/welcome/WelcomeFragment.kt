package com.agungfir.gojek.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agungfir.gojek.databinding.FragmentWelcomeBinding

class WelcomeFragment(private var image: Int, private var title: String, private var desc: String) :
    Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentWelcomeBinding.inflate(inflater)

        binding.apply {
            tvTitleWelcome.text = title
            tvDescWelcome.text = desc
            imgWelcome.setImageResource(image)
        }

        return binding.root
    }
}