package com.softplan.api.service;

import com.softplan.api.model.Cliente;
import com.softplan.api.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServico {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public Optional<Cliente> buscarClientePorId(Long id) {
        return clienteRepositorio.findById(id);
    }
}
