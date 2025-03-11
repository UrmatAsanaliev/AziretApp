package com.nonmagis.aziretapp.ui.fragments.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.nonmagis.aziretapp.R
import com.nonmagis.aziretapp.databinding.ItemImagePagerBinding

class ImagePagerAdapter: Adapter<ImagePagerAdapter.ViewHolder>() {

    private val img: Array<Int> = arrayOf(
        R.drawable.img,
        R.drawable.img_1,
    )

    inner class ViewHolder(private val binding: ItemImagePagerBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(img: Int) {
            binding.img.setImageResource(img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImagePagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(img[position])
    }

    override fun getItemCount(): Int = img.size
}