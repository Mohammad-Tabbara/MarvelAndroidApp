package com.opensource.marvelcharacters.presentation._common.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.opensource.marvelcharacters.R
import com.opensource.marvelcharacters.presentation._common.models.Character
import com.opensource.marvelcharacters.presentation._common.custom.PaginationListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.character_item.view.*

class MarvelCharactersAdapter(private val characters: MutableList<Character>, private val marvelAdapterListener: MarvelAdapterListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class CellName{
        Character,Loading;
    }


    private val paginationListener = PaginationListener(object : PaginationListener.LoadMore{
        override fun loadMore(offset:Int) {
            marvelAdapterListener.loadMore(offset)
            notifyItemInserted(characters.size)
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == CellName.Character.ordinal){
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.character_item,parent,false)
            CharacterHolder(v)
        }else{
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.data_loading,parent,false)
            ProgressHolder(v)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(position < characters.size) CellName.Character.ordinal else CellName.Loading.ordinal
    }

    override fun getItemCount(): Int = if(!paginationListener.isLoading) characters.size else characters.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is CharacterHolder) {
            holder.characterName.text = characters[position].name
            Picasso.get().load(characters[position].thumbnail)
                .into(holder.characterImage)
            holder.rootLayout.setOnClickListener {
                marvelAdapterListener.marvalCharacterClick(position)
            }
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(paginationListener)
    }

    fun updateData() {
        paginationListener.isLoading = false
        notifyItemRemoved(characters.size)
        if(itemCount < characters.size) {
            notifyItemRangeInserted(itemCount, characters.size)
        }
    }

    fun loadMoreFailed() {
        paginationListener.isLoading = false
        notifyItemRemoved(characters.size)
    }

    inner class CharacterHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val rootLayout : ConstraintLayout = itemView.rootLayout
        val characterName: TextView = itemView.characterName
        val characterImage: ImageView = itemView.characterImage
    }
    inner class ProgressHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    interface MarvelAdapterListener{
        fun loadMore(offset: Int){}
        fun marvalCharacterClick(position: Int)
    }
}