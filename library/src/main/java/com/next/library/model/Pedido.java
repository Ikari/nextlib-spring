package com.next.library.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author roger
 */
@Document
public class Pedido {
    
    private @Id ObjectId id;
    private long numero;
    private @DBRef Cliente cliente;
    private Date data;
    private Date ultimaAtualizacao;
    private String status;
    private int estado;
    private List<ItemPedido> itens;
    private FormaPagamento formaPagamento;
    private @DBRef Endereco enderecoEntrega;
    
    public Pedido(){
        this.itens = new ArrayList<>();
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
     * @return the numero
     */
    public long getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(long numero) {
        this.numero = numero;
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
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the itens
     */
    public List<ItemPedido> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
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

    /**
     * @return the enderecoEntrega
     */
    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    /**
     * @param enderecoEntrega the enderecoEntrega to set
     */
    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
    
    public void adicionarItem(Produto produto, int quantidade){        
        this.getItens().add(new ItemPedido(produto, quantidade));
    }
    
    public double getValorTotal(){
        double valorTotal = 0;
        
        for (ItemPedido item : getItens())
            valorTotal += item.getQuantidade() * item.getValorUnitario();
        
        return valorTotal;
    }
    
    public String getDescricaoFormaPagamento(){
        switch (this.getFormaPagamento()) {
            case BOLETO:
                return "Boleto Bancário";
            case CARTAO_CREDITO:
                return "Cartão de Crédito";
            default:
                return "Nenhuma forma de pagamento selecionada";
        }
    }

    /**
     * @return the ultimaAtualizacao
     */
    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    /**
     * @param ultimaAtualizacao the ultimaAtualizacao to set
     */
    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        
        switch (estado) {
            case 0:
                status = "Aguardando Pagamento";
                break;
            case 1:
                status = "Pedido Em Processamento";
            break;
            case 2:
                status = "Faturamento";
                break;
            case 3:
                status = "Em Transporte";
            break;
            case 4:
                status = "Entregue";
            break;
            default:
                status = "Sem estado";
        }
        
        this.estado = estado;
    }
}
