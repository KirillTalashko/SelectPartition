package com.example.selectpartition.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.selectpartition.databinding.FragmentProductSelectionBinding
import com.example.selectpartition.domain.repository.ProductSelectionRepositoryImpl
import com.example.selectpartition.domain.state.ProductSectionFragmentState
import com.example.selectpartition.presentation.adapter.ProductAdapter
import com.example.selectpartition.presentation.utils.CustomViewModelFactory
import com.example.selectpartition.presentation.viewModel.ProductSectionViewModel

class ProductSectionFragment : Fragment() {

    private var _binding: FragmentProductSelectionBinding? = null
    val binding
        get() = _binding!!

    private val viewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProvider(
            this,
            factory = CustomViewModelFactory(repository = ProductSelectionRepositoryImpl())
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
        val adapterProduct = ProductAdapter()
        binding.recyclerViewProducts.adapter = adapterProduct
        observerViewModel(adapterProduct)
    }

    private fun observerViewModel(adapter: ProductAdapter) {
        viewModel.stateProductSelection.observe(viewLifecycleOwner) { productSection ->
            when (productSection) {
                is ProductSectionFragmentState.Error -> Unit
                ProductSectionFragmentState.LoadingProduct -> Unit
                is ProductSectionFragmentState.SuccessProduct -> {

                    adapter.submitList(productSection.product[0].products)

                    binding.viewPagerSection.registerOnPageChangeCallback(object :
                        ViewPager2.OnPageChangeCallback() {
                        override fun onPageSelected(position: Int) {
                            super.onPageSelected(position)
                        }
                    })
                }
            }

        }
    }


}