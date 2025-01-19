package com.example.selectpartition.presentation.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.selectpartition.R
import com.example.selectpartition.data.model.Section
import com.example.selectpartition.databinding.FragmentItemBinding
import com.example.selectpartition.presentation.fragment.adapter.ProductAdapter

class ItemFragment : Fragment() {

    private var _binding: FragmentItemBinding? = null
    val binding
        get() = _binding!!

    private var section: Section? = null

    companion object {
        private const val ARG_SECTION = "arg_section"

        fun newInstance(section: Section): ItemFragment {
            return ItemFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(ARG_SECTION, section)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            section = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getParcelable(ARG_SECTION, Section::class.java)
            } else {
                it.getParcelable(ARG_SECTION) as? Section
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentItemBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ProductAdapter(getString(R.string.default_currency))
        section?.let { section ->
            binding.recyclerViewProducts.adapter = adapter
            adapter.submitList(section.products)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}