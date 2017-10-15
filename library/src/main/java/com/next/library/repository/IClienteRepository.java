/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.repository;

import com.next.library.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IClienteRepository extends MongoRepository<Cliente, Integer> {
    public Cliente findClienteByEmail(String email);
    public Cliente findClienteByUsername(String username);
    public Cliente findClienteByCpf(String cpf);
}
