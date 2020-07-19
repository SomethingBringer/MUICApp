package com.example.android.muicapp.ui.fragment.notifications.basic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.android.muicapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_basic_notification.*
import kotlinx.android.synthetic.main.toast_simple.*
import kotlinx.android.synthetic.main.toast_simple.view.tvMessage
import kotlinx.android.synthetic.main.toast_with_icon.toast_layout_root
import kotlinx.android.synthetic.main.toast_with_icon.view.*
import kotlinx.android.synthetic.main.toast_with_icon.view.tvText


class BasicNotificationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_basic_notification, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks() {
        btnSSimple.setOnClickListener {
            Snackbar.make(it, "Simple snackbar", Snackbar.LENGTH_SHORT)
                .show()
        }
        btnSWithAction.setOnClickListener {
            val snackbar = Snackbar.make(it, "Snackbar with action", Snackbar.LENGTH_LONG)
            snackbar.setAction("Dismiss") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
        btnSIndefinite.setOnClickListener {
            val snackbar =
                Snackbar.make(it, "Snackbar with action indefinite", Snackbar.LENGTH_INDEFINITE)
            snackbar.setAction("Dismiss") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
        btnTSimple.setOnClickListener {
            Toast.makeText(it.context, "Simple toast", Toast.LENGTH_SHORT)
                .show()
        }
        btnTCustom.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_simple, toast_root)
            layout.tvMessage.text = getString(R.string.custom_toast)
            val toast = Toast(it.context)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
        }
        btnTIcon.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.toast_with_icon, toast_layout_root)
            layout.tvText.text = getString(R.string.custom_toast)
            layout.ivIcon.setImageDrawable(
                ContextCompat.getDrawable(
                    it.context,
                    R.drawable.ic_baseline_grade
                )
            )
            val toast = Toast(it.context)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
        }
    }
}