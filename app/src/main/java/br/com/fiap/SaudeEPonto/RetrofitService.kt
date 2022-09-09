package br.com.fiap.SaudeEPonto

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


        //https://api.openweathermap.org/data/2.5/weather?lat=-23.47&lon=-46.86&appid=2ee0e67017a74af3747eecf78dd93c00
        @GET("weather?lat={latitude}&lon={longitude}&appid={apiKey}")
        fun getWeather(
            @Path("latitude") latitude: String,
            @Path("longitude") longitude: String,
            @Path("apiKey") apiKey: String): Call<Weather>


}