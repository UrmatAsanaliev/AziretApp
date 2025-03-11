package com.nonmagis.aziretapp.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nonmagis.aziretapp.R
import com.nonmagis.aziretapp.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private val binding: FragmentDetailBinding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }
    private val adapter: ImagePagerAdapter by lazy {
        ImagePagerAdapter()
    }

    var data  = arrayOf(
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            (activity as AppCompatActivity).supportActionBar!!.title = "Корзина"
        }
        val arrayAdapter: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, data)
        binding.edSearch.setAdapter(arrayAdapter)
        binding.edSearch.threshold = 0

        binding.imgMain.adapter = adapter


        TabLayoutMediator(
            binding.boardTab, binding.imgMain
        ) { tab: TabLayout.Tab, _: Int ->
            tab.setIcon(
                R.drawable.indicator_selector
            )
        }.attach()
    }
}