package com.xiaomi.hm.healt.wht

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.xiaomi.hm.healt.R
import kotlinx.android.synthetic.main.dialog.*

class Dialog: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corners);
        return inflater.inflate(R.layout.dialog, container, false)

    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)

        btn_ok.setOnClickListener {
            dialog!!.cancel()
        }
    }
}