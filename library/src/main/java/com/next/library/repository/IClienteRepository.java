package com.next.library.repository;

import com.next.library.model.Cliente;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IClienteRepository extends MongoRepository<Cliente, ObjectId> {
    public Cliente findClienteByCpf(String cpf);
}
