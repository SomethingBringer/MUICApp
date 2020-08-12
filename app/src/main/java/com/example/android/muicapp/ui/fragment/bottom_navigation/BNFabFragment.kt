package com.example.android.muicapp.ui.fragment.bottom_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.muicapp.R
import com.example.android.muicapp.models.Feed
import kotlinx.android.synthetic.main.fragment_b_n_fab.*


class BNFabFragment : Fragment() {

    private lateinit var feedAdapter: FeedAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_b_n_fab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler(view)
        fab.setOnClickListener {

        }

        val feedList = mutableListOf<Feed>()
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/06/nyregion/00nyvirus-schoolsHFO/merlin_175370388_5e723ec8-9174-47aa-950a-c8012dab604f-threeByTwoSmallAt2X.jpg?quality=75&auto=webp&disable=upscale",
            title = "N.Y. Schools Can Reopen",
            added = false
        ))
        feedList.add(Feed(
            image = "https://static01.nyt.com/images/2020/08/07/world/07bolivia/07bolivia-videoLarge.jpg",
            title = "Bolivia Under Blockade",
            added = false
        ))
        feedAdapter.submit(feedList)
    }

    private fun initRecycler(view: View) {
        feedAdapter = FeedAdapter()
        recyclerFeed.apply {
            adapter = feedAdapter
            layoutManager = GridLayoutManager(view.context, 2)
        }
    }
}