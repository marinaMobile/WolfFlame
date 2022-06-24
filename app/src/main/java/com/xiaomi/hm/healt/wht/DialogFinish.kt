package com.xiaomi.hm.healt.wht

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.xiaomi.hm.healt.R
import kotlinx.android.synthetic.main.dialog.*

class DialogFinish : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.round_corners);
        return inflater.inflate(R.layout.finish, container, false)

    }
    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.85).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog!!.setOnCancelListener {
            val intent = requireActivity().intent
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_NO_ANIMATION
            )
            requireActivity().overridePendingTransition(0, 0)
            requireActivity().finish()

            requireActivity().overridePendingTransition(0, 0)
            startActivity(intent)
        }

        btn_ok.setOnClickListener {
            dialog!!.cancel()
            val intent = requireActivity().intent
            intent.addFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                        or Intent.FLAG_ACTIVITY_NO_ANIMATION
            )
            requireActivity().overridePendingTransition(0, 0)
            requireActivity().finish()

            requireActivity().overridePendingTransition(0, 0)
            startActivity(intent)
        }
    }
}