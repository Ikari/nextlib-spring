package com.next.library.repository;

import com.next.library.model.Cliente;
import com.next.library.model.Pedido;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IPedidoRepository extends MongoRepository<Pedido, ObjectId> { 
    public List<Pedido> findPedidoByCliente(Cliente cliente, Sort sort);
}
