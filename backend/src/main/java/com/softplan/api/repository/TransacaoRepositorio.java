package com.softplan.api.repository;

import com.softplan.api.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepositorio extends JpaRepository<Transacao, Long> {
}
