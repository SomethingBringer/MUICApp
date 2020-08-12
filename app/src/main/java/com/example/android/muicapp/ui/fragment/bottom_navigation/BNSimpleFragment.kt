package com.example.android.muicapp.ui.fragment.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.muicapp.R
import com.example.android.muicapp.models.Album
import com.example.android.muicapp.ui.GlideApp
import kotlinx.android.synthetic.main.fragment_b_n_simple.*

class BNSimpleFragment : Fragment() {

    lateinit var recommendedAdapter: AlbumsAdapter
    lateinit var newReleasesAdapter: AlbumsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_n_simple, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlideApp.with(view)
            .load("https://avatars.yandex.net/get-music-content/2811629/48b5f957.a.10499954-1/m1000x1000")
            .into(ivTopRating)
        initAdapters()
        setAlbums()
        initClicks()
    }

    private fun initAdapters() {
        this.newReleasesAdapter = AlbumsAdapter(R.layout.item_new_release)
        this.recommendedAdapter = AlbumsAdapter(R.layout.item_recommended)
        recyclerNew.apply {
            adapter = newReleasesAdapter
        }
        recyclerRecommended.apply {
            adapter = recommendedAdapter
        }
    }

    private fun setAlbums() {
        val recommendedAlbums = listOf(
            Album(
                "https://avatars.yandex.net/get-music-content/108289/5d37df75.a.4703896-1/m1000x1000",
                "Enter Shikari",
                "The Spark"
            ),
            Album(
                "https://avatars.yandex.net/get-music-content/193823/9f85494a.a.5468632-1/m1000x1000",
                "Комсомольск",
                "Дорогие москвичи"
            ),
            Album(
                "https://img.discogs.com/KfKUCjSQjWQcq-7zy5eAZL1SQ4Y=/fit-in/600x600/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-13302183-1551698216-2336.jpeg.jpg",
                "Bicycles for Afghanistan",
                "Пена дней"
            )
        )
        recommendedAdapter.submit(recommendedAlbums)
        val newAlbums = listOf(
            Album(
                "https://exclaim.ca/images/neck-deep-all-distortions-are-intentional.jpg",
                "Neck Deep",
                "All Distortions Are Intentional"
            ),
            Album(
                "https://images.genius.com/d01ae63bd1f7c9410e36dfe463f21c87.1000x1000x1.png",
                "Oliver Tree",
                "Ugly is Beautiful"
            )
        )
        newReleasesAdapter.submit(newAlbums)
    }

    private fun initClicks(){
        btnMore1.setOnClickListener {  }
        btnMore2.setOnClickListener {  }
    }
}