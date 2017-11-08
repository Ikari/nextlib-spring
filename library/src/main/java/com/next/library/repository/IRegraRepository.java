package com.next.library.repository;

import com.next.library.model.Regra;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IRegraRepository extends MongoRepository<Regra, Integer> {
    Regra findRegraByRegra(String regra);
}
