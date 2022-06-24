package com.xiaomi.hm.healt.black

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.orhanobut.hawk.Hawk
import com.xiaomi.hm.healt.R
import com.xiaomi.hm.healt.wht.StartGame
import com.xiaomi.hm.healt.wht.WolfGame
import kotlinx.coroutines.*

class Filter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        val txtEr: TextView = findViewById(R.id.inviteTxt)
        runBlocking {

            val job: Job = GlobalScope.launch(Dispatchers.IO) {
                getAsync(applicationContext)
            }
            job.join()
            val jsoup: String? = Hawk.get(Const.asyncResult, "")
            Log.d("cora", "cora $jsoup")

            txtEr.text = jsoup

            if (jsoup == "2vBx") {
                Intent(applicationContext, StartGame::class.java).also { startActivity(it) }
            } else {
                Intent(applicationContext, Web::class.java).also { startActivity(it) }
            }
            finish()
        }
    }
    private suspend fun getAsync(context: Context) {
        val asyncKey = Sou(context)
        val asyncResult = asyncKey.getDocSecretKey()
        Hawk.put(Const.asyncResult, asyncResult)
    }
}