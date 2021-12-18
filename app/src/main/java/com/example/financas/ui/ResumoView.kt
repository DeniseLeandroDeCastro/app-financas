package com.example.financas.ui

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import com.example.financas.R
import com.example.financas.extension.formataParaBrasileiro
import com.example.financas.model.Resumo
import com.example.financas.model.Transacao
import kotlinx.android.synthetic.main.resumo_card.view.*
import java.math.BigDecimal

class ResumoView(
    private val context: Context,
    private val view: View,
    transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    private val corReceita = ContextCompat.getColor(context, R.color.receita)
    private val corDespesa = ContextCompat.getColor(context, R.color.despesa)
    private val corTotal = ContextCompat.getColor(context, R.color.total)

    fun atualiza() {
        adicionaReceita()
        adicionaDespesa()
        adicionaTotal()
    }

    private fun adicionaReceita() {
        val totalReceita = resumo.receita
        with(view.resumo_card_receita) {
            setTextColor(corReceita)
            text =totalReceita.formataParaBrasileiro()
        }
    }

    private fun adicionaDespesa() {
        val totalDespesa = resumo.despesa
        with(view.resumo_card_despesa) {
            setTextColor(corDespesa)
            text =totalDespesa.formataParaBrasileiro()
        }
    }

    private fun adicionaTotal() {
        val total = resumo.total
        val cor = corPor(total)
        with(view.resumo_card_total) {
            setTextColor(cor)
            text = total.formataParaBrasileiro()
        }
    }

    private fun corPor(valor: BigDecimal): Int {
        if (valor compareTo (BigDecimal.ZERO) > 0) {
            return corReceita
        } else if (valor compareTo (BigDecimal.ZERO) < 0) {
            return corDespesa
        }
        return corTotal
    }
}