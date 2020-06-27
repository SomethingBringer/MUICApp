package com.example.android.muicapp.ui.fragment.buttons

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.android.muicapp.MyApplication
import com.example.android.muicapp.R
import kotlinx.android.synthetic.main.fragment_buttons_basic.*
import javax.inject.Inject

class ButtonsBasicFragment : Fragment() {

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    lateinit var viewModel: ButtonsBasicViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as MyApplication).appComponent.inject(this)
        viewModel = ViewModelProvider(this,providerFactory).get(ButtonsBasicViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons_basic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
    }

    private fun initClicks(){
        fabMMid.setOnClickListener {  }
        fabUMid.setOnClickListener {  }
        fabMEnd.setOnClickListener {  }
        fabUEnd.setOnClickListener {  }
        fabMStart.setOnClickListener {  }
        fabUStart.setOnClickListener {  }
    }

}