package com.next.library.repository;

import com.next.library.model.Pedido;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IPedidoRepository extends MongoRepository<Pedido, ObjectId> { }
