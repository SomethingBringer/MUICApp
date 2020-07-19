package com.example.android.muicapp.ui.fragment.notifications.toasts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.android.muicapp.R
import kotlinx.android.synthetic.main.fragment_toast.*
import kotlinx.android.synthetic.main.toast_card_dark.*
import kotlinx.android.synthetic.main.toast_card_image.*
import kotlinx.android.synthetic.main.toast_card_light.*
import kotlinx.android.synthetic.main.toast_error.*
import kotlinx.android.synthetic.main.toast_info.*
import kotlinx.android.synthetic.main.toast_success.*

class ToastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_toast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        btnCardLight.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_card_light, toast_light_root)
            showToastFromView(layout)
        }
        btnCardDark.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_card_dark, toast_dark_root)
            showToastFromView(layout)
        }
        btnCardImage.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_card_image, toast_image_root)
            showToastFromView(layout)
        }
        btnSuccess.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_success, success_root)
            showToastFromView(layout)
        }
        btnError.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_error, error_root)
            showToastFromView(layout)
        }
        btnInfo.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_info, info_root)
            showToastFromView(layout)
        }
    }

    private fun showToastFromView(layout: View) {
        val toast = Toast(layout.context)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.show()
    }
}