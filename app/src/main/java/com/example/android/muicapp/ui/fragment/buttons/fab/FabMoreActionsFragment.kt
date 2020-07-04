package com.example.android.muicapp.ui.fragment.buttons.fab

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.muicapp.MyApplication
import com.example.android.muicapp.R
import kotlinx.android.synthetic.main.fragment_fab_more_actions.*
import javax.inject.Inject


class FabMoreActionsFragment : Fragment() {

    var animationFase = 0

    @Inject
    lateinit var providerFactory: ViewModelProvider.Factory
    lateinit var viewModel: FabMoreActionsViewModel
    lateinit var personsAdapter: PersonsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        (activity?.application as MyApplication).appComponent.inject(this)
        viewModel =
            ViewModelProvider(this, providerFactory).get(FabMoreActionsViewModel::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observePersons()
    }

    private fun observePersons() {
        viewModel.personsList.observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                personsAdapter.setData(it)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fab_more_actions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dividerItemDecoration = DividerItemDecoration(view.context, RecyclerView.VERTICAL)
        ContextCompat.getDrawable(view.context, R.drawable.divider)?.let {
            dividerItemDecoration.setDrawable(it)
        }
        initAdapter(dividerItemDecoration)
        viewModel.fetchPersons()
        initClicks()
    }

    private fun initAdapter(divider: DividerItemDecoration) {
        personsAdapter = PersonsAdapter()
        rvPersons.apply {
            adapter = personsAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(divider)
        }
    }

    private fun initClicks() {
        fabMain.setOnClickListener {
            val rotateAnimator = ObjectAnimator.ofFloat(fabMain, View.ROTATION, 0f, 135f)
            val fadeInAnimator1 = ObjectAnimator.ofFloat(fabMin1, View.ALPHA, 1f)
            val fadeInAnimator2 = ObjectAnimator.ofFloat(fabMin2, View.ALPHA, 1f)
            val fadeOutAnimator1 = ObjectAnimator.ofFloat(fabMin1, View.ALPHA, 0f)
            val fadeOutAnimator2 = ObjectAnimator.ofFloat(fabMin2, View.ALPHA, 0f)
            val moveUpAnimator1 = ObjectAnimator.ofFloat(fabMin1, View.TRANSLATION_Y, -300f)
            val moveUpAnimator2 = ObjectAnimator.ofFloat(fabMin2, View.TRANSLATION_Y, -150f)
            val moveDownAnimator1 = ObjectAnimator.ofFloat(fabMin1, View.TRANSLATION_Y, 10f)
            val moveDownAnimator2 = ObjectAnimator.ofFloat(fabMin2, View.TRANSLATION_Y, 10f)
            if (animationFase == 0) {
                rotateAnimator.start()
                fabMin1.show()
                fabMin1.alpha = 0f
                fabMin2.show()
                fabMin2.alpha = 0f
                fadeInAnimator1.start()
                fadeInAnimator2.start()
                moveUpAnimator1.start()
                moveUpAnimator2.start()
                animationFase = 1
            } else {
                rotateAnimator.reverse()
                moveDownAnimator1.start()
                moveDownAnimator2.start()
                fadeOutAnimator1.start()
                fadeOutAnimator2.start()
                fabMin1.hide()
                fabMin2.hide()
                animationFase = 0
            }
        }
        fabMin1.setOnClickListener { viewModel.fetchPersons() }
        fabMin2.setOnClickListener { }
    }
}