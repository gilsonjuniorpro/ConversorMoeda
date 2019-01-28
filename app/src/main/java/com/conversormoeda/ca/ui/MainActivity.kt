package com.conversormoeda.ca.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.conversormoeda.ca.R
import com.conversormoeda.ca.util.Dominios
import com.conversormoeda.ca.util.Util
import kotlinx.android.synthetic.main.fragment_moeda_a.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btConverter.setOnClickListener{ converterMoeda() }
    }


    fun converterMoeda() {
        doAsync {
            val json = URL(Dominios.URL_API_BASE + Dominios.URL_API_USD_BRL + Dominios.URL_API_TYPE).readText()

            var retorno = Util.calcular(json, edFrom.text.toString())

            uiThread {
                tvTo.text = "R$ " + retorno.toString()
            }
        }
    }
}
