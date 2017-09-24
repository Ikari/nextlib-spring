/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author roger.roliveira
 */
@Entity
public class Carrinho implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @ElementCollection
    @OneToMany
    private List<ProdutoCarrinho> produtos;
    @OneToOne
    private Cliente cliente;
    private double valorTotal;

    public Carrinho(){
        setProdutos(new ArrayList<>());
        setValorTotal(0);
    }   
    
    public void AdicionarProduto(Produto produto){
        this.AdicionarProduto(produto, 1);
    }
    
    public void AdicionarProduto(Produto produto, int quantidade){
                
        for (ProdutoCarrinho item : produtos)
            if (item.getProduto().getId() == produto.getId()){
                item.adicionar();
                return;
            }
        
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
