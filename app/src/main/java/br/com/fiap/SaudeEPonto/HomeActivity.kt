package br.com.fiap.SaudeEPonto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

lateinit var buttonWork: Button

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        buttonWork = findViewById(R.id.btn_personalStatus)


        // Ouvinte de click do botão de login
        buttonWork.setOnClickListener {
            work()
        }
    }

    private fun work() {

        val latitude =  "-24.47"
        val longitude =  "-48.86"
        val apiKey =  "2ee0e67017a74af3747eecf78dd93c00"

        val current = LocalDateTime.now()
        val currentFormater = DateTimeFormatter.ofPattern("HH:mm:ss")
        val currentFormated = current.format(currentFormater)

        //Toast.makeText(applicationContext,"Have a nice day of work, $currentFormated", Toast.LENGTH_LONG).show()


        val callWeather =
            RetrofitFactory().retrofitService().getWeather(
            latitude,
            longitude,
            apiKey
        )

        callWeather.enqueue(object : Callback<Weather> {

            override fun onResponse(callWeather: Call<Weather>?, response: Response<Weather>?) {

                response?.body()?.let {
                    Log.i("name", it.toString())
                    Toast.makeText(this@HomeActivity, it.toString(), Toast.LENGTH_LONG).show()
                }
                    ?: Toast.makeText(
                        this@HomeActivity,
                        "Chamada meio-OK, retorno foi negativo",
                        Toast.LENGTH_LONG
                    )
                        .show()
            }

            override fun onFailure(callWeather: Call<Weather>?, t: Throwable?) {
                t?.message?.let { it1 -> Log.e("Erro!!", it1) }
            }
        })



    }


        //if (msg.trim().length<5) {
        //    Toast.makeText(applicationContext, "Please enter a valid email", Toast.LENGTH_SHORT).show()
        //}else{
        //    val openHome = Intent(this, HomeActivity::class.java)
        //    startActivity(openHome)
        //}


}
