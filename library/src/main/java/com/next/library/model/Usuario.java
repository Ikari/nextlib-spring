/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.model;

import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 *
 * @author roger
 */
public class Usuario {
    
    private ObjectId id;
    private @Indexed(unique=true) String email;
    private String password;
    private Cliente cliente;
    private List<Regra> regras;

    public Usuario(String email, String password){
        this.email = email;
        this.password = password;
    }
    
    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the regras
     */
    public List<Regra> getRegras() {
        return regras;
    }

    /**
     * @param regras the regras to set
     */
    public void setRegras(List<Regra> regras) {
        this.regras = regras;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
}
