package com.vero.sibs.ui.buy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.vero.sibs.R
import com.vero.sibs.adapter.ProductAdapter
import com.vero.sibs.databinding.FragmentBuyBinding
import com.vero.sibs.ext.showToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyFragment : Fragment(R.layout.fragment_buy) {

    private val viewModel: BuyViewModel by viewModels()
    private lateinit var binding: FragmentBuyBinding
    private val adapter = ProductAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_buy, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.adapter = adapter

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        showToolbar(true)
    }
}