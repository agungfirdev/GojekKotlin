package com.agungfir.gojek.welcome

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.gojek.databinding.ActivityWelcomeBinding
import com.agungfir.gojek.language.ChangeLanguageFragment
import com.agungfir.gojek.main.MainActivity


class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vpWelcome.adapter = WelcomePagerAdapter(supportFragmentManager)

        binding.tabsWelcome.setupWithViewPager(binding.vpWelcome, true)


        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.tvLanguages.setOnClickListener {
            val bottomSheetLanguage = ChangeLanguageFragment()
            bottomSheetLanguage.show(supportFragmentManager, "Bottom Sheet Dialog Language")
        }
    }

}