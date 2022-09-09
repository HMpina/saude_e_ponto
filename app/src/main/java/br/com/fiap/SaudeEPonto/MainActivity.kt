package br.com.fiap.SaudeEPonto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


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

        val msg: String = textEmail.text.toString()
        if (msg.trim().length<5) {
            Toast.makeText(applicationContext, "Please enter a valid email", Toast.LENGTH_SHORT).show()
        }else{
            val openHome = Intent(this, HomeActivity::class.java)
            startActivity(openHome)
        }

    }

}

