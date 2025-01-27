package com.agungfir.gojek.main.fragment.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.agungfir.gojek.databinding.FragmentChatBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior


class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        BottomSheetBehavior.from(binding.bottomSheetChat).apply {
            state = BottomSheetBehavior.STATE_EXPANDED
            isFitToContents = true
        }

        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}