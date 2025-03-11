package com.nonmagis.aziretapp.ui.fragments.bottom_nav.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nonmagis.aziretapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    var data  = arrayOf(
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        "Ак-ниет. Инн 9998 7877. Г.Ош ",
        )

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (activity != null) {
            (activity as AppCompatActivity).supportActionBar!!.title = "Каталог"
        }
        val adapter: ArrayAdapter<*> = ArrayAdapter<Any?>(requireContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, data)
        binding.edSearch.setAdapter(adapter)
        binding.edSearch.threshold = 0

    }
}