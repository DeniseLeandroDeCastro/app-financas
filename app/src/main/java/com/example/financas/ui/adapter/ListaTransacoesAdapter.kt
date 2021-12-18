package com.example.financas.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import com.example.financas.R
import com.example.financas.extension.formataParaBrasileiro
import com.example.financas.extension.limitaEmAte
import com.example.financas.model.Tipo
import com.example.financas.model.Transacao
import kotlinx.android.synthetic.main.transacao_item.view.*

class ListaTransacoesAdapter(private val transacoes: List<Transacao>,
                             private val context: Context) : BaseAdapter() {

    private val limiteDaCategoria = 14

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context)
            .inflate(R.layout.transacao_item, parent, false)

        val transacao = transacoes[position]

        adicionaValor(transacao, viewCriada)
        adicionaIcone(transacao, viewCriada)
        adicionaCategoria(transacao, viewCriada)

        viewCriada.transacao_data.text = transacao.data
            .formataParaBrasileiro()

        return viewCriada
    }
    private fun adicionaCategoria(
        transacao: Transacao,
        viewCriada: View
    ) {
        if (transacao.categoria == "Indefinida") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.financas)
        } else if (transacao.categoria == "Economias") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.moedas)
        } else if (transacao.categoria == "Empréstimo") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.sem_dinheiro)
        } else if(transacao.categoria == "Pagamento") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.financas)
        } else if(transacao.categoria == "Presente") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.presente)
        } else if(transacao.categoria == "Salário") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.salario)
        } else if(transacao.categoria == "Casa") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.casa)
        } else if(transacao.categoria == "Comida") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.comida)
        } else if(transacao.categoria == "Comunicações") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.net)
        } else if(transacao.categoria == "Contas") {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.contas)
        } else {
            viewCriada.transacao_icone.setBackgroundResource(R.drawable.moedas)
        }
        viewCriada.transacao_categoria.text = transacao.categoria
            .limitaEmAte(limiteDaCategoria)
    }
    private fun adicionaIcone(transacao: Transacao,viewCriada: View) {
        val icone = iconePor(transacao.tipo)
        viewCriada.transacao_icone.setBackgroundResource(icone)
    }

    private fun iconePor(tipo: Tipo) : Int {
        if (tipo == Tipo.RECEITA) {
            return R.drawable.icone_transacao_item_receita
        }
            return R.drawable.icone_transacao_item_despesa
    }

    private fun adicionaValor(transacao: Transacao, viewCriada: View) {
        val cor: Int = corPor(transacao.tipo)
        viewCriada.transacao_valor.setTextColor(cor)
        viewCriada.transacao_valor.text = transacao.valor
            .formataParaBrasileiro()
    }

    private fun corPor(tipo: Tipo) : Int {
        if (tipo == Tipo.RECEITA) {
            return ContextCompat.getColor(context, R.color.receita)
        }
            return ContextCompat.getColor(context, R.color.despesa)
        }

    override fun getCount(): Int {
        return transacoes.size
    }

    override fun getItem(position: Int): Transacao {
        return transacoes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
}