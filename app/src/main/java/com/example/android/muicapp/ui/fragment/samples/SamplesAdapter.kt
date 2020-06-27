package com.example.android.muicapp.ui.fragment.samples

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Transformation
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.android.muicapp.R
import com.example.android.muicapp.models.ActionID
import com.example.android.muicapp.models.CategoryID
import com.example.android.muicapp.models.SampleCategory
import kotlinx.android.synthetic.main.item_sample_category.view.*
import kotlinx.android.synthetic.main.item_sample_category.view.tvTitle

class SamplesAdapter : RecyclerView.Adapter<SamplesAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var list = listOf<SampleCategory>()
    private val animationDuration = 300L
    private lateinit var onSelectClickListener: ((actionID: ActionID) -> Unit)

    fun setOnSelectClickListener(onSelectClickListener: (actionID: ActionID) -> Unit) {
        this.onSelectClickListener = onSelectClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sample_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        var isExpanded = false
        holder.itemView.tvTitle.text = item.name
        when (item.categoryID) {
            CategoryID.BUTTONS -> holder.itemView.ivCategoryIcon.setImageDrawable(
                ContextCompat.getDrawable(
                    holder.itemView.context,
                    R.drawable.ic_tap
                )
            )
        }
        item.subList.forEach{
            if (holder.itemView.llSubcategories.childCount>0){
                holder.itemView.llSubcategories.removeViewAt(0)
            }
        }
        item.subList.forEach {
            val subcategory = it
            val layoutInflater = LayoutInflater.from(holder.itemView.context)
            val view = layoutInflater.inflate(
                R.layout.item_sample_subcategory,
                holder.itemView.llSubcategories,
                false
            )
            view.tvTitle.text = subcategory.name
            view.setOnClickListener {
                onSelectClickListener.invoke(subcategory.actionID)
            }
            holder.itemView.llSubcategories.addView(view, 0)
        }
        holder.itemView.setOnClickListener { view ->
            isExpanded = if (isExpanded) {
                collapseRotation(view.ivArrow)
                view.llSubcategories.startAnimation(collapseView(view.llSubcategories))
                false
            } else {
                expandRotation(view.ivArrow)
                view.llSubcategories.startAnimation(expandView(view.llSubcategories))
                true
            }
        }
    }

    fun setData(list: List<SampleCategory>) {
        this.list = list
        notifyDataSetChanged()
    }

    private fun expandRotation(view: View) {
        view.animate().setDuration(animationDuration).rotation(180f)
    }

    private fun collapseRotation(view: View) {
        view.animate().setDuration(animationDuration).rotation(0f)
    }

    private fun expandView(v: View): Animation {

        v.measure(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        val height = v.measuredHeight
        v.layoutParams.height = 0
        v.visibility = View.VISIBLE

        val animation: Animation = object : Animation() {
            override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation?
            ) {
                v.layoutParams.height =
                    if (interpolatedTime == 1f) {
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    } else {
                        (height * interpolatedTime).toInt()
                    }
                v.requestLayout()
            }
        }
        animation.duration = animationDuration

        v.startAnimation(animation)
        return animation
    }

    private fun collapseView(v: View): Animation {

        val height = v.measuredHeight

        val animation: Animation = object : Animation() {
            override fun applyTransformation(
                interpolatedTime: Float,
                t: Transformation?
            ) {
                if (interpolatedTime == 1f) {
                    v.visibility = View.GONE
                } else {
                    v.layoutParams.height = height - (height * interpolatedTime).toInt()
                    v.requestLayout()
                }
            }
        }
        animation.duration = animationDuration
        return animation
    }
}