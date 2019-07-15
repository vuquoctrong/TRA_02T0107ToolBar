package com.rikkei.tra_02t0107toolbar.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.rikkei.tra_02t0107toolbar.R
import com.rikkei.tra_02t0107toolbar.model.People

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleHolder>() {
    private var peopeles: MutableList<People>? = null
    private var peopleOnclickListener: PeopleOnclickListener? = null

    fun setListPeople(list: MutableList<People>) {
        this.peopeles = list
        notifyDataSetChanged()
    }


    fun setPeopleOnclickListener(onClick: PeopleOnclickListener) {
        this.peopleOnclickListener = onClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder =
        PeopleHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_peoplelist, parent, false))


    override fun getItemCount(): Int {
        return if (peopeles != null) {
            peopeles?.size!!
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) {
        var people = peopeles?.get(position)
        holder.id.text = people?.id
        holder.name.text = people?.name
        holder.age.text = people?.age.toString()
        holder.imgage.setOnClickListener { peopleOnclickListener?.onClickItem(holder.adapterPosition) }


    }

    class PeopleHolder(v: View) : RecyclerView.ViewHolder(v) {
        val id: TextView = v.findViewById(R.id.tvIdPeople)
        val name: TextView = v.findViewById(R.id.tvNamePeople)
        val age: TextView = v.findViewById(R.id.tvAgePeople)
        val imgage: ImageView = v.findViewById(R.id.ivImage)
    }

    interface PeopleOnclickListener {
        fun onClickItem(position: Int)
    }
}