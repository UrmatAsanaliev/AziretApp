package com.nonmagis.aziretapp.ui.fragments.basket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.nonmagis.aziretapp.R
import com.nonmagis.aziretapp.databinding.FragmentBasketBinding

class BasketFragment : Fragment() {

    private val binding: FragmentBasketBinding by lazy {
        FragmentBasketBinding.inflate(layoutInflater)
    }

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
    }

}