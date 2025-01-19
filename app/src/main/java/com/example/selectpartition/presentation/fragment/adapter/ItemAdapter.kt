package com.example.selectpartition.presentation.fragment.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.selectpartition.data.model.Section
import com.example.selectpartition.presentation.fragment.ItemFragment

class ItemAdapter(
    fragmentActivity: FragmentActivity,
    private val sections: List<Section>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return sections.size
    }

    override fun createFragment(position: Int): Fragment {
        return ItemFragment.newInstance(sections[position])
    }
}