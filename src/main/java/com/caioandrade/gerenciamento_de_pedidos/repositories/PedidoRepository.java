package com.caioandrade.gerenciamento_de_pedidos.repositories;

import com.caioandrade.gerenciamento_de_pedidos.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>
{

}
