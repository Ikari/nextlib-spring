package com.next.library.service;

import com.next.library.model.Endereco;
import com.next.library.model.Pedido;
import com.next.library.repository.IPedidoRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author roger
 */
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CheckoutService {

    @Autowired HttpServletRequest _request;
    @Autowired IPedidoRepository _repository;
    
    private void salvarSession(Pedido pedido){
        _request.getSession().setAttribute("pedido", pedido);
    }
    
    private Pedido obterSession() {
        Object p = _request.getSession().getAttribute("pedido");        
        return p == null ? criarPedido() : (Pedido)p;    
    }
    
    private Pedido criarPedido(){
        
        Pedido pedido = new Pedido();
        pedido.setNumero(System.currentTimeMillis());        
        
        _repository.save(pedido);
        
        salvarSession(pedido);
        
        return pedido;
    }
    
    public Pedido obterPedido() {        
        return obterSession();
    }
    
    public void adicionarEndereco(Endereco endereco) {
        
        Pedido pedido = obterPedido();
        pedido.setEnderecoEntrega(endereco);
        
        _repository.save(pedido);
        
        salvarSession(pedido);
    }
    
    public void finalizarPedido() {
    
        Pedido pedido = obterPedido();        
        _repository.save(pedido);
    }
}
