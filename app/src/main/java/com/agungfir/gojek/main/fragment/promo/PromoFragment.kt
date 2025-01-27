package com.agungfir.gojek.main.fragment.promo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agungfir.gojek.databinding.FragmentPromoBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PromoFragment : Fragment() {

    private lateinit var binding: FragmentPromoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPromoBinding.inflate(inflater, container, false)
        BottomSheetBehavior.from(binding.bottomSheetChat).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            isFitToContents = true
        }

        return binding.root
    }

}