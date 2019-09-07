package org.furs.kweather.ui.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import org.furs.kweather.R
import org.furs.kweather.ui.fragment.FragmentToday
import org.furs.kweather.ui.fragment.FragmentTomorrow
import org.furs.kweather.ui.fragment.FragmentWeek

private val tabs = arrayOf(
    FragmentToday.newInstance(),
    FragmentTomorrow.newInstance(),
    FragmentWeek.newInstance()
)

private val titles = arrayOf(
    R.string.today_title,
    R.string.tomorrow_title,
    R.string.week
)

class WeatherTabAdapter(private val context: Context, fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return tabs[position]
    }

    override fun getCount() = tabs.size

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(titles[position])
    }
}