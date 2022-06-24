package com.xiaomi.hm.healt.black

import android.content.Context
import com.orhanobut.hawk.Hawk
import com.xiaomi.hm.healt.black.Const.CAMPL1
import com.xiaomi.hm.healt.black.Const.DEEPL1
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup

class Sou (val context: Context) {
    private var jsoup: String? = "null"
    private val hawk : String? = Hawk.get(CAMPL1)
    private val hawkAppLink: String? = Hawk.get(DEEPL1)

    private var forJsoupSetNaming: String = Const.FilterURL + Const.subber1 + hawk
    private var forJsoupSetAppLnk: String = Const.FilterURL + Const.subber1 + hawkAppLink
    suspend fun getDocSecretKey(): String?{
        withContext(Dispatchers.IO){
            if(hawk!=null) {
                val doc = Jsoup.connect(forJsoupSetNaming).get()
                jsoup = doc.text().toString()
            } else {
                val doc = Jsoup.connect(forJsoupSetAppLnk).get()
                jsoup = doc.text().toString()
            }
        }
        return jsoup
    }
}