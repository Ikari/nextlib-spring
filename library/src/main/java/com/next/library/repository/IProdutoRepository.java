package com.next.library.repository;

import com.next.library.model.Produto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author roger
 */
public interface IProdutoRepository extends CrudRepository<Produto, Integer> {
    
    //List<Produto> obterPorEan(String ean);    
}
