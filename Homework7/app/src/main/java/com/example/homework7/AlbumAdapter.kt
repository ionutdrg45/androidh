package com.example.homework7

import android.content.ClipData
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.CheckBox
import com.bumptech.glide.Glide

class AlbumAdapter(private val mList: List<AlbumViewModel>) : RecyclerView.Adapter<AlbumAdapter.ViewHolder>() {

    var listener: FavAlbumClickListener ?= null

    fun setAlbumClickListener(albumsListener: FavAlbumClickListener) {
        listener = albumsListener
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val ItemsViewModel = mList[position]
        val albumDetails = ItemsViewModel.name
            .plus("\n")
            .plus(ItemsViewModel.genre)
            .plus("\n")
            .plus(ItemsViewModel.age)

        // sets the image to the imageview from our itemHolder class
        Glide.with(holder.imageView.context).load(ItemsViewModel.thumbnail).fitCenter().into(holder.imageView)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = albumDetails
        holder.checkFav.isChecked = ItemsViewModel.favourite
        setOnItemClickListener(holder, position)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.profilePic)
        val textView: TextView = itemView.findViewById(R.id.details)
        val checkFav: CheckBox = itemView.findViewById(R.id.favCheck)
    }

    private fun setOnItemClickListener(holder: ViewHolder, position: Int) {
        holder.imageView.setOnClickListener {
            listener?.onAlbumImageClicked(mList[position])
        }
        holder.textView.setOnClickListener {
            listener?.onAlbumDetailsClicked(mList[position])
        }
        holder.checkFav.setOnClickListener {
            listener?.onHeartClicked(mList[position])
        }
    }

    interface FavAlbumClickListener {
        fun onAlbumImageClicked(album: AlbumViewModel)
        fun onAlbumDetailsClicked(album: AlbumViewModel)
        fun onHeartClicked(album: AlbumViewModel)
    }
}