package com.victor.financekotlinapp.ui.frangment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class FragmentManagerViewPager(private val fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragments: MutableList<FragmentResource> = mutableListOf()

    fun addFragment(vararg fragment: FragmentResource) {
        for (f in fragment) {
            fragments.add(f)
        }
    }

    override fun getItem(position: Int): Fragment {
        val fragmentResourse = fragments[position]
        return fragmentResourse.fragment
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val fragmentResource = fragments[position]
        return fragmentResource.title
    }
}