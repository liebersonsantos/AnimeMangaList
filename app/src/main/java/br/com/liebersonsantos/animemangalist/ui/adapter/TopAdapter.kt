package br.com.liebersonsantos.animemangalist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.liebersonsantos.animemangalist.data.model.Top
import br.com.liebersonsantos.animemangalist.databinding.ItemAnimeBinding
import com.bumptech.glide.Glide

/**
 * Created by lieberson on 10/19/21.
 * @author lieberson.xsantos@gmail.com
 */
class TopAdapter(
    private val clickedItem: ((top: Top) -> Unit)
) : ListAdapter<Top, TopAdapter.AdapterViewHolder>(DIFF_CALLBACK) {
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val itemBinding =
            ItemAnimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(itemBinding, clickedItem)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
        animation(holder.itemView, position)
    }

    private fun animation(view: View, position: Int){
        if (position > lastPosition){
            val animation: Animation = AnimationUtils.loadAnimation(view.context, android.R.anim.slide_in_left)
            view.startAnimation(animation)
            lastPosition = position
        }
    }

    class AdapterViewHolder(
        private val itemAnimeBinding: ItemAnimeBinding,
        private val clickedItem: (top: Top) -> Unit
    ) : RecyclerView.ViewHolder(itemAnimeBinding.root) {

        fun bind(top: Top) {
            itemAnimeBinding.run {
                Glide.with(itemView).load(top.imageUrl).into(ivAnime)

                itemView.setOnClickListener {
                    clickedItem.invoke(top)
                }
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Top>() {
            override fun areItemsTheSame(oldItem: Top, newItem: Top): Boolean {
                return oldItem.malId == newItem.malId
            }

            override fun areContentsTheSame(oldItem: Top, newItem: Top): Boolean {
                return oldItem == newItem
            }
        }
    }

}
