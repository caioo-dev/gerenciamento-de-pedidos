package com.caioandrade.gerenciamento_de_pedidos.services;

import com.caioandrade.gerenciamento_de_pedidos.entities.ClienteEntity;
import com.caioandrade.gerenciamento_de_pedidos.entities.PedidoEntity;
import com.caioandrade.gerenciamento_de_pedidos.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteService clienteService;

    public PedidoService(PedidoRepository pedidoRepository, ClienteService clienteService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    public PedidoEntity criarPedido(Long clienteId, PedidoEntity pedido){
        ClienteEntity cliente = clienteService.buscarClientePorId(clienteId);
        pedido.setCliente(cliente);
        return pedidoRepository.save(pedido);
    }

    public List<PedidoEntity> listarPedidos(){
        return pedidoRepository.findAll();
    }

    public PedidoEntity buscarPedidoPorId(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public PedidoEntity atualizarPedido(Long id, PedidoEntity pedido){
        PedidoEntity pedidoExistente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedidoExistente.setDataPedido(pedido.getDataPedido());
        pedidoExistente.setValorTotal(pedido.getValorTotal());
        pedidoExistente.setCliente(pedido.getCliente());

        return pedidoRepository.save(pedidoExistente);
    }

    public void excluirPedido(Long id){
        pedidoRepository.deleteById(id);
    }
}
