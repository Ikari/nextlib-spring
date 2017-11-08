package com.next.library.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 *
 * @author roger
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Cliente implements Serializable {
        
    private @Id ObjectId id;
       
    private String nome;    
    private @Indexed(unique=true) String cpf;
    private String nascimento;
    private String telefone;
    private @DBRef List<Endereco> enderecos;
    private @DBRef List<Pedido> pedidos;
    
    public Cliente(){ }

    /**
     * @return the id
     */
    public ObjectId getId() {
        return id;
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
     * @return the enderecos
     */
    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /**
     * @param enderecos the enderecos to set
     */
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public void adicionarEndereco(Endereco endereco){
        this.getEnderecos().add(endereco);
    }

    /**
     * @param id the id to set
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * @return the pedidos
     */
    public List<Pedido> getPedidos() {
        return pedidos;
    }

    /**
     * @param pedidos the pedidos to set
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    /**
     * @return the nascimento
     */
    public String getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
