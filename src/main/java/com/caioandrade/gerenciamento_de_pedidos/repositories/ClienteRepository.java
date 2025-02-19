package com.caioandrade.gerenciamento_de_pedidos.repositories;

import com.caioandrade.gerenciamento_de_pedidos.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
