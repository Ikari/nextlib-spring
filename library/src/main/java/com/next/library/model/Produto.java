package com.next.library.model;

import java.io.Serializable;
import java.util.Base64;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author roger
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Produto implements Serializable {
    
    @Id
    private int id;
    private String nome;
    private String descricao;
    private Double preco;
    private String ean;
    private byte[] imagem;    
    
    public Produto(){        
    }    
    
    public Produto(int id, String nome, String descricao, Double preco, byte[] imagem){
        setId(id);
        setNome(nome);
        setDescricao(descricao);
        setPreco(preco);
        setImagem(imagem);
    }
    
    public Produto(int id, String nome, String descricao, Double preco, byte[] imagem, String ean){
        this(id, nome, descricao, preco, imagem);
        setEan(ean);
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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the preco
     */
    public Double getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(Double preco) {
        this.preco = preco;
    }

    /**
     * @return the ean
     */
    public String getEan() {
        return ean;
    }

    /**
     * @param ean the ean to set
     */
    public void setEan(String ean) {
        this.ean = ean;
    }

    /**
     * @return the imagem
     */
    public byte[] getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
    public String getBase64Imagem(){        
        return imagem == null ? null : Base64.getEncoder().encodeToString(imagem);
    }
}
