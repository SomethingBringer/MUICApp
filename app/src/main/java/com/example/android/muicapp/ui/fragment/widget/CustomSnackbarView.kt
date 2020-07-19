package com.example.android.muicapp.ui.fragment.widget

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.android.muicapp.R
import com.google.android.material.snackbar.ContentViewCallback
import kotlinx.android.synthetic.main.custom_snackbar.view.*

class CustomSnackbarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), ContentViewCallback {

    init {
        View.inflate(context, R.layout.custom_snackbar, this)
        clipToPadding = false
    }

    override fun animateContentOut(delay: Int, duration: Int) {

    }

    override fun animateContentIn(delay: Int, duration: Int) {
        val scaleX = ObjectAnimator.ofFloat(ivFace, View.SCALE_X, 0f, 1f)
        val scaleY = ObjectAnimator.ofFloat(ivFace, View.SCALE_Y, 0f, 1f)
        val animatorSet = AnimatorSet().apply {
            interpolator = OvershootInterpolator()
            setDuration(500)
            playTogether(scaleX, scaleY)
        }
        animatorSet.start()
    }
}