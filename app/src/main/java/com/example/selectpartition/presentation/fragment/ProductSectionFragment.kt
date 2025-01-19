package com.example.selectpartition.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.selectpartition.R
import com.example.selectpartition.data.model.Section
import com.example.selectpartition.databinding.FragmentProductSelectionBinding
import com.example.selectpartition.domain.repository.ProductSelectionRepositoryImpl
import com.example.selectpartition.domain.state.ProductSectionFragmentState
import com.example.selectpartition.presentation.fragment.adapter.ItemAdapter
import com.example.selectpartition.presentation.fragment.viewModel.ProductSectionViewModel
import com.example.selectpartition.presentation.utils.CustomViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator

class ProductSectionFragment : Fragment() {

    private var _binding: FragmentProductSelectionBinding? = null
    val binding
        get() = _binding!!

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(
            this,
            factory = CustomViewModelFactory(
                repository = ProductSelectionRepositoryImpl(),
                error = getString(R.string.empty_list)
            )
        )[ProductSectionViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductSelectionBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observerViewModel()
    }

    private fun observerViewModel() {
        viewModel.stateProductSelection.observe(viewLifecycleOwner) { section ->
            when (section) {
                is ProductSectionFragmentState.Error -> {
                    binding.progressBarSwitchProduct.visibility = View.GONE
                    binding.textViewError.visibility = View.VISIBLE
                }

                ProductSectionFragmentState.LoadingProduct -> {
                    binding.textViewError.visibility = View.GONE
                    binding.progressBarSwitchProduct.visibility = View.VISIBLE
                }

                is ProductSectionFragmentState.SuccessProduct -> {
                    binding.progressBarSwitchProduct.visibility = View.GONE
                    setupViewPager(section.product)
                }

            }
        }
    }

    private fun setupViewPager(section: List<Section>) {
        binding.viewPagerSection.adapter =
            ItemAdapter(requireActivity(), section)

        TabLayoutMediator(binding.tabLayoutSection, binding.viewPagerSection) { tab, position ->
            tab.text = section[position].name
        }.attach()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}