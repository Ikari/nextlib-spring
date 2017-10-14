package com.next.library.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author roger
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Regra implements GrantedAuthority {
    
    @Id
    private int id;
    private String regra;

    public Regra(String regra){
        this.regra = regra;
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
     * @return the regra
     */
    public String getRegra() {
        return regra;
    }

    /**
     * @param regra the regra to set
     */
    public void setRegra(String regra) {
        this.regra = regra;
    }

    @Override
    public String getAuthority() {
        return regra; //To change body of generated methods, choose Tools | Templates.
    }
}
