package com.conversormoeda.ca.util

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Util {

    fun calcular(json: String, valorInicial: String): Float {
        var gson = Gson()
        var valorConvertido = 0F
        var moedaMap: Map<String, Map<String, Any>> = gson.fromJson(json, object : TypeToken<Map<String, Map<String, Any>>>() {}.type)
        moedaMap.forEach {
            //Log.i("DE_PARA", it.key)
            var fromTo = it.key
            var valor = it.value
            valor.forEach {
                //Log.i("KEY", it.key)
                //Log.i("VAL", it.value.toString())
                var valorMoedaFinal = it.value.toString()
                valorConvertido = valorInicial.toFloat() * valorMoedaFinal.toFloat()
            }
        }
        //Log.i("API_MOEDA", json)

        return valorConvertido
    }
}