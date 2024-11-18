package com.softplan.api.service;

import com.softplan.api.model.Cliente;
import com.softplan.api.model.Transacao;
import com.softplan.api.repository.ClienteRepositorio;
import com.softplan.api.repository.TransacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransacaoServico {

    @Autowired
    private TransacaoRepositorio transacaoRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Transacao criarTransacao(Long clienteId, Transacao transacao) {
        Cliente cliente = clienteRepositorio.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));

        if (transacao.getTipo().equals("d")) {
            if (cliente.getSaldo() - transacao.getValor() < -cliente.getLimite()) {
                throw new IllegalStateException("Saldo insuficiente para débito");
            }
            cliente.setSaldo(cliente.getSaldo() - transacao.getValor());
        } else if (transacao.getTipo().equals("r")) {
            cliente.setSaldo(cliente.getSaldo() + transacao.getValor());
        } else {
            throw new IllegalArgumentException("Tipo de transação inválido");
        }

        transacao.setRealizadaEm(LocalDateTime.now());
        transacao.setCliente(cliente);

        clienteRepositorio.save(cliente);
        return transacaoRepositorio.save(transacao);
    }

    public List<Transacao> listarUltimasTransacoes(Long clienteId) {
        Cliente cliente = clienteRepositorio.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return transacaoRepositorio.findAllByClienteOrderByRealizadaEmDesc(cliente);
    }
}
