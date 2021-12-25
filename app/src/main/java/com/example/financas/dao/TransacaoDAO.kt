package com.example.financas.dao

import com.example.financas.model.Transacao
import java.text.FieldPosition

class TransacaoDAO {

    val transacoes: MutableList<Transacao> = mutableListOf()

    fun adiciona(transacao: Transacao) {
        transacoes.add(transacao)
    }

    fun altera(transacao: Transacao, posicao: Int) {
        transacoes[posicao] = transacao
    }

    fun remove(posicao: Int) {
        transacoes.removeAt(posicao)
    }
}