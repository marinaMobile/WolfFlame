package com.xiaomi.hm.healt.wht

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xiaomi.hm.healt.R
import kotlinx.android.synthetic.main.activity_start_game.*

class StartGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_game)

        startBtn.setOnClickListener{
            startActivity(Intent(this, WolfGame::class.java))
        }
    }
}