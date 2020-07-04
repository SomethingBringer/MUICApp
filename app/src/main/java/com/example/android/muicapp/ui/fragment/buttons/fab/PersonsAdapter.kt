package com.example.android.muicapp.ui.fragment.buttons.fab

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.muicapp.R
import com.example.android.muicapp.models.Person
import com.example.android.muicapp.ui.GlideApp
import kotlinx.android.synthetic.main.item_person.view.*

class PersonsAdapter : RecyclerView.Adapter<PersonsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    var list = listOf<Person>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_person, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        GlideApp.with(holder.itemView)
            .load(item.photo)
            .into(holder.itemView.ivPhoto)
        holder.itemView.tvName.text = item.name
        holder.itemView.tvDescription.text = item.description
    }

    fun setData(list: List<Person>){
        this.list = list
        notifyDataSetChanged()
    }
}