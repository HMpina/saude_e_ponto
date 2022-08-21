package br.com.fiap.SaudeEPonto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

lateinit var buttonLogin: Button
lateinit var textEmail : EditText
lateinit var textPassword : EditText


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin = findViewById(R.id.button_login)
        textEmail = findViewById(R.id.editTextEmailAddress)
        textPassword = findViewById(R.id.editTextPassword)


        // Ouvinte de click do botão de login
        buttonLogin.setOnClickListener {
            login()
        }



    }

    private fun login() {


        val openHome = Intent(this, HomeActivity::class.java)
        startActivity(openHome)

    }
}