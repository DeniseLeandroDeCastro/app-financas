package com.example.financas.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.financas.R
import android.content.Intent
import android.os.Handler


class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        mostrarListaTransacoes()
    }

    private fun mostrarListaTransacoes() {
        val intent = Intent(this, ListaTransacoesActivity::class.java)
        Handler().postDelayed({
            intent.mostrar()
        }, 2000)
    }
    fun Intent.mostrar() {
        startActivity(this)
        finish()
    }
}