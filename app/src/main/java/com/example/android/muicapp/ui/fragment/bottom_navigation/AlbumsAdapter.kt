package com.example.android.muicapp.ui.fragment.bottom_navigation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.muicapp.core.RecyclerAdapter
import com.example.android.muicapp.models.Album
import com.example.android.muicapp.ui.GlideApp
import kotlinx.android.synthetic.main.item_new_release.view.*
import kotlinx.android.synthetic.main.item_recommended.*

class AlbumsAdapter(
    private val layoutId: Int
) : RecyclerAdapter<Album>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<Album> {

        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)

        return object : BindingHolder<Album>(view) {
            override fun bind(model: Album, position: Int) {
                view.tvAlbum.text = model.name
                view.tvArtist.text = model.artist
                GlideApp.with(view)
                    .load(model.photo)
                    .into(view.ivAlbum)
            }
        }
    }
}