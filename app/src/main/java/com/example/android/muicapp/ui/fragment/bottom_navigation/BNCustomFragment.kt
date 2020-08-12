package com.example.android.muicapp.ui.fragment.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.muicapp.R
import com.example.android.muicapp.ui.GlideApp
import kotlinx.android.synthetic.main.fragment_b_n_custom.*


class BNCustomFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_n_custom, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlideApp.with(view)
            .load("https://i0.wp.com/images-prod.healthline.com/hlcmsresource/images/topic_centers/Anxiety/1296x728_HEADER_10_Ways_to_Naturally_Reduce_Anxiety.jpg?w=1155")
            .into(image)
    }
}