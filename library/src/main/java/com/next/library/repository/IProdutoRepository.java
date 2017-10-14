package com.next.library.repository;

import com.next.library.model.Produto;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author roger
 */
public interface IProdutoRepository extends MongoRepository<Produto, Integer> {
    
    //List<Produto> obterPorEan(String ean);    
}
