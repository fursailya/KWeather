package org.furs.kweather

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import org.furs.kweather.data.CurrentWeather
import org.furs.kweather.data.network.ApiService
import org.furs.kweather.ui.adapter.WeatherTabAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupTabsWithAdapter()
        getCurrentWeather()
    }

    private fun setupTabsWithAdapter() {
        val weatherTabAdapter =
            WeatherTabAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = weatherTabAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
    }

    private fun getCurrentWeather() {
        val api = ApiService.createApi()
        val apiCall: Call<CurrentWeather> = api.getCurrentWeather(
            53.3180426F,
            50.3165991F,
            BuildConfig.WEATHER_API_KEY,
            BuildConfig.DEFAULT_UNITS
        )

        apiCall.enqueue(object: Callback<CurrentWeather> {
            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                Log.d("Main", t.message)
            }

            override fun onResponse(
                call: Call<CurrentWeather>,
                response: Response<CurrentWeather>
            ) {
                if(response.isSuccessful) {
                    val currentForecast = response.body()
                    val main = currentForecast?.main.toString()
                    val city = currentForecast?.cityName.toString()
                    Toast.makeText(this@MainActivity, "В городе $city в данный момент $main градусов", Toast.LENGTH_SHORT).show()
                }
            }

        })
    }
}
