package com.caioandrade.gerenciamento_de_pedidos.services;

import com.caioandrade.gerenciamento_de_pedidos.entities.ClienteEntity;
import com.caioandrade.gerenciamento_de_pedidos.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteEntity criarCliente(ClienteEntity cliente){
        return clienteRepository.save(cliente);
    }

    public List<ClienteEntity> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteEntity buscarClientePorId(Long id){
        return clienteRepository.findById(id).get();
    }
}
