package com.example.android.muicapp.ui.fragment.buttons.custom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.muicapp.MyApplication
import com.example.android.muicapp.R
import javax.inject.Inject


class ButtonsCustomFragment : Fragment() {

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    lateinit var viewModel: ButtonsCustomViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as MyApplication).appComponent.inject(this)
        viewModel = ViewModelProvider(this,providerFactory).get(ButtonsCustomViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons_custom, container, false)
    }

}