package org.furs.kweather.ui.fragment

import androidx.fragment.app.Fragment
import org.furs.kweather.R

class FragmentToday : Fragment(R.layout.fragment_today) {

    companion object {
        fun newInstance(): FragmentToday {
            return FragmentToday()
        }
    }
}