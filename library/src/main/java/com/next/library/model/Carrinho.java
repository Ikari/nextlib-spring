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
import org.bson.types.ObjectId;

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
        this.produtos = new ArrayList<>();
        this.valorTotal = 0;
    }   
    
    public void adicionarProduto(Produto produto){
        this.adicionarProduto(produto, 1);        
    }
    
    public void adicionarProduto(Produto produto, int quantidade){
                
        for (ProdutoCarrinho item : produtos)
            if (item.getProduto().getId().equals(produto.getId())) {
                item.adicionar();
                return;
            }
        
        produtos.add(new ProdutoCarrinho(produto, quantidade));        
        recalcularTotal();
    }
    
    public void removerProduto(ObjectId id){
        
        ProdutoCarrinho item = null;
        
        for (ProdutoCarrinho produto : this.produtos)
            if (produto.getProduto().getId().equals(id))
                item = produto;
        
        this.produtos.remove(item);
    }
    
    private void recalcularTotal(){
        valorTotal = 0;
        produtos.forEach(p -> valorTotal += (p.getProduto().getPreco() * p.getQuantidade()));
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
