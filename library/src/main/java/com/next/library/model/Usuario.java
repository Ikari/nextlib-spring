/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.model;

import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author roger
 */
public class Usuario {
    
    private ObjectId id;
    private String username;
    private String password;
    private List<Regra> regras;

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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
}
