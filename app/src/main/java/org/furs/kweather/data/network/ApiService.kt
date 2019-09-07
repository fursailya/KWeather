package org.furs.kweather.data.network

import org.furs.kweather.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object {
        fun createApi(): ForecastApi {
            val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ForecastApi::class.java)
        }
    }


}