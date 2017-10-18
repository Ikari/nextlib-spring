/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.repository;

import com.next.library.dtos.ProdutoDto;
import com.next.library.model.Produto;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author roger.roliveira
 */
@RepositoryRestResource(excerptProjection=ProdutoDto.class)
public interface IProdutoExcertpRepository extends MongoRepository<Produto, ObjectId> {    
}
