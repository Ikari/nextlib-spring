/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.dtos;

import com.next.library.model.Produto;
import org.bson.types.ObjectId;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author roger.roliveira
 */
@Projection(name="produto-dto", types={Produto.class})
public interface ProdutoDto {
    ObjectId getId();
    String getNome();
    String getDescricao();
    Double getPreco();
    byte[] getThumbnail();
    String getAlt();
}
