package com.xiaomi.hm.healt.wht

import android.animation.ObjectAnimator
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.xiaomi.hm.healt.R
import kotlinx.android.synthetic.main.activity_wolf_game.*

class WolfGame : AppCompatActivity() {
    var currentProgress: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wolf_game)

        progress_bar.progressTintList = ColorStateList.valueOf(Color.WHITE);

        progress_bar.max = 100
        wolf.setOnClickListener{
            currentProgress++
            ObjectAnimator.ofInt(progress_bar, "progress", currentProgress)
                .start()
            if (currentProgress==100) {
                progress_bar.visibility = View.INVISIBLE
                wolf.visibility = View.INVISIBLE
                DialogFinish().show(supportFragmentManager, "MyDialog")
            }
        }
        }
}