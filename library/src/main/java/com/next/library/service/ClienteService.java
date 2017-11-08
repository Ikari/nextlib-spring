package com.next.library.service;

import com.next.library.model.Cliente;
import com.next.library.model.Endereco;
import com.next.library.repository.IClienteRepository;
import com.next.library.repository.IEnderecoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author roger
 */

@Component
public class ClienteService {
    
    @Autowired private IClienteRepository repository;
    @Autowired private IEnderecoRepository enderecoRepository;
    
    public Cliente cadastrarCliente(Cliente cliente){
        
        if(validarCpfCadastrado(cliente.getCpf()))
            return null;
        
        repository.save(cliente);
        
        return cliente;
    }
    
    public void cadastrarEndereco(ObjectId clienteId, Endereco endereco){
        
        Cliente cliente = repository.findOne(clienteId);
        
        enderecoRepository.save(endereco);
        
        cliente.adicionarEndereco(endereco);
        
        repository.save(cliente);
    }
    
    private boolean validarCpfCadastrado(String cpf){
        return repository.findClienteByCpf(cpf) != null;
    }
}
