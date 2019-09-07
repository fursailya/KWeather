package org.furs.kweather.data

import com.google.gson.annotations.SerializedName

data class CurrentWeather(
    val main: ForecastMain,
    val wind: ForecastWind,
    @SerializedName("name")
    val cityName: String
) {
    override fun toString(): String {
        return "CurrentWeather(" +
                "forecastMain=$main," +
                " forecastWind=$wind, " +
                "cityName='$cityName')"
    }
}