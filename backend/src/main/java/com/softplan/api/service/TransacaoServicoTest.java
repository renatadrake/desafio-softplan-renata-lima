package com.softplan.api.service;

import com.softplan.api.model.Cliente;
import com.softplan.api.model.Transacao;
import com.softplan.api.repository.ClienteRepositorio;
import com.softplan.api.repository.TransacaoRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransacaoServicoTest {

    @InjectMocks
    private TransacaoServico transacaoServico;

    @Mock
    private TransacaoRepositorio transacaoRepositorio;

    @Mock
    private ClienteRepositorio clienteRepositorio;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cliente = new Cliente("Teste Cliente", 100000, 0);
        cliente.setId(1L);
    }

    @Test
    void criarTransacaoComRecebivel() {
        Transacao transacao = new Transacao(1000, "r", "Teste", null, cliente);

        when(clienteRepositorio.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        when(transacaoRepositorio.save(any())).thenReturn(transacao);

        Transacao resultado = transacaoServico.criarTransacao(cliente.getId(), transacao);

        assertEquals(1000, resultado.getValor());
        assertEquals("r", resultado.getTipo());
        assertEquals(1000, cliente.getSaldo());
        verify(clienteRepositorio, times(1)).save(cliente);
        verify(transacaoRepositorio, times(1)).save(transacao);
    }

    @Test
    void criarTransacaoComDebitoSaldoInsuficiente() {
        Transacao transacao = new Transacao(200000, "d", "Teste", null, cliente);

        when(clienteRepositorio.findById(cliente.getId())).thenReturn(Optional.of(cliente));

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            transacaoServico.criarTransacao(cliente.getId(), transacao);
        });

        assertEquals("Saldo insuficiente para débito", exception.getMessage());
        verify(clienteRepositorio, never()).save(cliente);
        verify(transacaoRepositorio, never()).save(transacao);
    }
}
