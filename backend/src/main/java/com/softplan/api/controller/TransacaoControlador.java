package com.softplan.api.controller;

import com.softplan.api.model.Transacao;
import com.softplan.api.service.TransacaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes/{clienteId}/transacoes")
public class TransacaoControlador {

    @Autowired
    private TransacaoServico transacaoServico;

    @PostMapping
    public ResponseEntity<Transacao> criarTransacao(@PathVariable Long clienteId, @RequestBody Transacao transacao) {
        try {
            return ResponseEntity.ok(transacaoServico.criarTransacao(clienteId, transacao));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (IllegalStateException e) {
            return ResponseEntity.unprocessableEntity().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Transacao>> listarUltimasTransacoes(@PathVariable Long clienteId) {
        try {
            return ResponseEntity.ok(transacaoServico.listarUltimasTransacoes(clienteId));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
