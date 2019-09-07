package org.furs.kweather.data.network

import org.furs.kweather.data.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {
    @GET("weather")
    fun getCurrentWeather(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey: String,
        @Query("units") units: String): Call<CurrentWeather>
}