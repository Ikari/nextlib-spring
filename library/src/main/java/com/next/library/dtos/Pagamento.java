/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.dtos;

import com.next.library.model.FormaPagamento;

/**
 *
 * @author roger
 */
public class Pagamento {
    
    private CartaoCredito cartao;
    private FormaPagamento formaPagamento;

    public Pagamento(){
        this.cartao = new CartaoCredito();
        this.formaPagamento = FormaPagamento.CARTAO_CREDITO;
    }
    
    /**
     * @return the cartao
     */
    public CartaoCredito getCartao() {
        return cartao;
    }

    /**
     * @param cartao the cartao to set
     */
    public void setCartao(CartaoCredito cartao) {
        this.cartao = cartao;
    }

    /**
     * @return the formaPagamento
     */
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
}
