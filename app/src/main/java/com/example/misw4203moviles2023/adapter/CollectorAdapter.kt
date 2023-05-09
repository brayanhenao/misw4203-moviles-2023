package com.example.misw4203moviles2023.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.misw4203moviles2023.data.model.CollectorModel
import com.example.misw4203moviles2023.databinding.CollectorRowBinding

interface OnCollectorClickListener {
    fun onItemClick(position: Int, collector: CollectorModel)
}

class CollectorAdapter(
    private val collectorList: List<CollectorModel>
) :
    RecyclerView.Adapter<CollectorAdapter.CollectorViewHolder>() {

    private var onItemClickListener: OnCollectorClickListener? = null

    inner class CollectorViewHolder(private val binding: CollectorRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(collector: CollectorModel) {
            binding.collectorName.text = collector.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorViewHolder {
        val binding =
            CollectorRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CollectorViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CollectorViewHolder, position: Int) {
        val collector = collectorList[position]
        holder.bind(collector)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position, collector)
        }
    }

    fun OnItemClickListener(listener: OnCollectorClickListener) {
        onItemClickListener = listener
    }

    override fun getItemCount() = collectorList.size
}
