package com.agungfir.gojek.language

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.agungfir.gojek.R
import com.agungfir.gojek.bottomsheetexpanded.BottomSheetDialogFragmentExpanded
import com.agungfir.gojek.databinding.FragmentChangeLanguageBinding


class ChangeLanguageFragment : BottomSheetDialogFragmentExpanded() {

    private lateinit var binding: FragmentChangeLanguageBinding
    private lateinit var languages: List<ImageView>

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChangeLanguageBinding.inflate(inflater)

        onClick()

        val bounce = AnimationUtils.loadAnimation(context, R.anim.bounce)
        binding.floatingActionButton.startAnimation(bounce)

        binding.root.setOnClickListener {
            dismiss()
        }
        return binding.root

    }

    private fun onClick() {
        languages = listOf(
            binding.ivChooseEN,
            binding.ivChooseIN,
            binding.ivChooseTH,
            binding.ivChooseVI,
        )

        languages.forEachIndexed { index, language ->
            language.setOnClickListener {
                selectLanguages(index)
            }
        }

        binding.floatingActionButton.setOnClickListener {
            dismiss()
        }
    }

    private fun selectLanguages(languageIndex: Int) {
        languages.forEachIndexed { index, language ->
            if (index == languageIndex) {
                language.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.greenChecked
                    )
                )
            } else {
                language.setColorFilter(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.greyUnchecked
                    )
                )
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireView().parent as View).apply {
            setBackgroundColor(Color.TRANSPARENT)
        }

    }
}