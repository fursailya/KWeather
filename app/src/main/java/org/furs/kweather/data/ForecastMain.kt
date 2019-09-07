package org.furs.kweather.data

import com.google.gson.annotations.SerializedName

data class ForecastMain(
    val temp: Float,
    val pressure: Float,
    val humidity: Float,
    @SerializedName("temp_min")
    val minTemp: Float,
    @SerializedName("temp_max")
    val maxTemp: Float
)