package com.next.library.repository;

import com.next.library.model.Produto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IProdutoRepository extends MongoRepository<Produto, ObjectId> {
    
}
