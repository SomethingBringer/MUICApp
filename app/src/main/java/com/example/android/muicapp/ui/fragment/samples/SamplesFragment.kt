package com.example.android.muicapp.ui.fragment.samples

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.muicapp.MyApplication
import com.example.android.muicapp.R
import com.example.android.muicapp.models.ActionID
import kotlinx.android.synthetic.main.fragment_samples.*
import javax.inject.Inject

class SamplesFragment : Fragment() {

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    lateinit var viewModel: SamplesViewModel
    lateinit var samplesAdapter: SamplesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.applicationContext as MyApplication).appComponent.inject(this)
        viewModel = ViewModelProvider(this, providerFactory).get(SamplesViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeSamples()
    }

    private fun observeSamples() {
        viewModel.samplesList.observe(viewLifecycleOwner, Observer { list ->
            if (list.isNotEmpty()) {
                samplesAdapter.setData(list)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_samples, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        viewModel.fetchSamples()
        initClicks()
    }

    private fun initAdapter() {
        this.samplesAdapter = SamplesAdapter()
        rvSamples.apply {
            adapter = samplesAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initClicks() {
        samplesAdapter.setOnSelectClickListener { actionID ->
            when (actionID) {
                ActionID.BUTTONS_BASIC -> {
                    findNavController()
                        .navigate(R.id.action_samplesFragment_to_buttonsBasicFragment)
                }
                ActionID.BUTTONS_CUSTOM -> {
                    findNavController()
                        .navigate(R.id.action_samplesFragment_to_buttonsCustomFragment)
                }
            }
        }
    }


}