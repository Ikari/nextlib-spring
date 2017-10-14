package com.next.library.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author roger
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Cliente implements Serializable {
    
    @Id
    private int id;
    
    private String username;
    private String password;    
    private String email;    
    private String nome;
    private String cpf;
    private List<Regra> regras;
    
    public Cliente(){ }
    
    public Cliente(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
