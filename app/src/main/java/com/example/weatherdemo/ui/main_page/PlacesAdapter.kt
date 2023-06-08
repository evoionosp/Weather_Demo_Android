package com.example.weatherdemo.ui.main_page

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherdemo.R

class PlacesAdapter<T> : RecyclerView.Adapter<PlacesAdapter.MyViewHolder>() {
    private var oldList = emptyList<T>()
    private var newList = emptyList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ComposeView(parent.context))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    fun updateList(newList: List<T>) {
        this.oldList = this.newList
        this.newList = newList

        val diffResult = DiffUtil.calculateDiff(MyDiffCallback(oldList, newList))
        diffResult.dispatchUpdatesTo(this)
    }

    class MyViewHolder(val composeView: ComposeView) : RecyclerView.ViewHolder(composeView) {
        fun bind(position: Int) {
            composeView.setContent {
                
            }
        }
    }

    class MyDiffCallback<T>(
        private val oldList: List<T>,
        private val newList: List<T>
    ) : DiffUtil.Callback() {

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].hashCode() == newList[newItemPosition].hashCode()
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }
    }
}