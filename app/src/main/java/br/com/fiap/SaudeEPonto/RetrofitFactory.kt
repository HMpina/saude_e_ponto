package br.com.fiap.SaudeEPonto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {


        val URL: String = "https://api.openweathermap.org/data/2.5/"
        val retrofitFactory = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

        fun retrofitService(): RetrofitService {
            return retrofitFactory.create(RetrofitService::class.java)
        }


}