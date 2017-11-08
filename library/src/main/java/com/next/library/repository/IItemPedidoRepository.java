/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.repository;

import com.next.library.model.Pedido;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IItemPedidoRepository extends MongoRepository<Pedido, ObjectId> { }
