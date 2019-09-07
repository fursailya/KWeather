package org.furs.kweather.data

import com.google.gson.annotations.SerializedName

data class ForecastWind(
    val speed: Float,
    @SerializedName("deg")
    val degree: Float) {
    override fun toString(): String {
        return "ForecastWind(speed=$speed, degree=$degree)"
    }
}