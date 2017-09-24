/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author roger.roliveira
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Carrinho implements Serializable {
    
    @Id
    private int id;
    private List<ProdutoCarrinho> produtos;
    private Cliente cliente;
    private double valorTotal;

    public Carrinho(){
        setProdutos(new ArrayList<ProdutoCarrinho>());
        setValorTotal(0);
    }    
    
    public void AdicionarProduto(Produto produto, int quantidade){
        produtos.add(new ProdutoCarrinho(produto, quantidade));
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
     * @return the produtos
     */
    public List<ProdutoCarrinho> getProdutos() {
        return produtos;
    }

    /**
     * @param produtos the produtos to set
     */
    public void setProdutos(List<ProdutoCarrinho> produtos) {
        this.produtos = produtos;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the valorTotal
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * @param valorTotal the valorTotal to set
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
