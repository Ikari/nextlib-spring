package com.next.library.dtos;

import java.util.Date;

/**
 *
 * @author roger
 */
public class CartaoCredito {
    
    private String numero;
    private Date validade;
    private String titular;
    private String ccv;

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the validade
     */
    public Date getValidade() {
        return validade;
    }

    /**
     * @param validade the validade to set
     */
    public void setValidade(Date validade) {
        this.validade = validade;
    }

    /**
     * @return the titular
     */
    public String getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(String titular) {
        this.titular = titular;
    }

    /**
     * @return the ccv
     */
    public String getCcv() {
        return ccv;
    }

    /**
     * @param ccv the ccv to set
     */
    public void setCcv(String ccv) {
        this.ccv = ccv;
    }
}