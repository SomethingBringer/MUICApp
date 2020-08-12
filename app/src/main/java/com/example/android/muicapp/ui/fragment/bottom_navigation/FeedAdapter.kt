package com.example.android.muicapp.ui.fragment.bottom_navigation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.android.muicapp.R
import com.example.android.muicapp.core.RecyclerAdapter
import com.example.android.muicapp.models.Feed
import com.example.android.muicapp.ui.GlideApp
import kotlinx.android.synthetic.main.item_feed.view.*

class FeedAdapter: RecyclerAdapter<Feed>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder<Feed> {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed, parent, false)

        return object : BindingHolder<Feed>(view){
            override fun bind(model: Feed, position: Int) {
                view.tvTitle.text = model.title
                GlideApp.with(view)
                    .load(model.image)
                    .into(view.ivHead)
                if (model.added){
                    view.ivActionIcon.setImageResource(R.drawable.ic_baseline_library_add_check)
                } else {
                    view.ivActionIcon.setImageResource(R.drawable.ic_baseline_library_add_24)
                }
                view.ivActionIcon.setOnClickListener{
                    model.added = !model.added
                    notifyItemChanged(position)
                }
            }
        }
    }
}