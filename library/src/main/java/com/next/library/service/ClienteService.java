package com.next.library.service;

import com.next.library.model.Cliente;
import com.next.library.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author roger
 */

@Component
public class ClienteService {
    
    @Autowired
    private IClienteRepository repository;
    
    public Cliente cadastrarCliente(Cliente cliente){
        
        if(validarCpfCadastrado(cliente.getCpf()) || 
           validarEmailCadastrado(cliente.getEmail()) ||
           validarUsernameCadastrado(cliente.getUsername()))
            return null;
        
        repository.save(cliente);
        
        return cliente;
    }
    
    private boolean validarCpfCadastrado(String cpf){
        return repository.findClienteByCpf(cpf) != null;
    }
    
    private boolean validarEmailCadastrado(String email){
        return repository.findClienteByEmail(email) != null;
    }
    
    private boolean validarUsernameCadastrado(String username){
        return repository.findClienteByUsername(username) != null;
    }
}
