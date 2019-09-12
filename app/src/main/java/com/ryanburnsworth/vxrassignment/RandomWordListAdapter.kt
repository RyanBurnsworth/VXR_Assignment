package com.ryanburnsworth.vxrassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_word_view.view.*

class RandomWordListAdapter(private val randomWordList: ArrayList<String>) :
    RecyclerView.Adapter<RandomWordListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_word_view,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(randomWordList[position])

    override fun getItemCount() = 0

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(randomWord: String) = with(itemView) {
            rnd_word_tv.text = randomWord
        }
    }
}
