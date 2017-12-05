/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import org.springframework.data.annotation.Id;

/**
 *
 * @author roger.roliveira
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class ProdutoCarrinho implements Serializable {
    
    @Id
    private int id;
    private Produto produto;
    private int quantidade;

    public ProdutoCarrinho(){
    }
    
    public ProdutoCarrinho(Produto produto){
        setProduto(produto);
        setQuantidade(1);
    }
    
    public ProdutoCarrinho(Produto produto, int quantidade){
        this(produto);
        setQuantidade(quantidade);
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public int adicionar(){
        return this.quantidade++;
    }
}
