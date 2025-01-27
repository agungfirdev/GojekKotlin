package com.agungfir.gojek.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.LinearLayout.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import com.agungfir.gojek.R
import com.agungfir.gojek.utils.dp
import com.agungfir.gojek.welcome.WelcomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val params = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
        val container = LinearLayout(this)
        container.orientation = LinearLayout.VERTICAL
        container.gravity = Gravity.CENTER
        container.layoutParams = params
        container.requestLayout()

        val ivLogo = ImageView(this)
        ivLogo.setImageResource(R.drawable.ic_logo_gojek)
        ivLogo.adjustViewBounds = true
        ivLogo.layoutParams = ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT, 84.dp)
        ivLogo.requestLayout()

        val ivText = ImageView(this)
        ivText.setImageResource(R.drawable.img_text_gojek)
        ivText.adjustViewBounds = true
        val paramsIvText = LayoutParams(LayoutParams.WRAP_CONTENT, 44.dp)
        paramsIvText.setMargins(0, 60, 0, 0)
        ivText.layoutParams = paramsIvText

        container.addView(ivLogo)
        container.addView(ivText)
        setContentView(container)
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, WelcomeActivity::class.java))
            finish()
        }, 2000)
    }
}