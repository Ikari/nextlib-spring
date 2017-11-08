package com.next.library.service;

import com.next.library.model.Endereco;
import com.next.library.model.FormaPagamento;
import com.next.library.model.Pedido;
import com.next.library.model.Usuario;
import com.next.library.repository.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author roger
 */
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class CheckoutService {

    @Autowired HttpServletRequest _request;
    @Autowired UsuarioService _usuarioService;
    @Autowired IPedidoRepository _repository;
    @Autowired IEnderecoRepository _endRepository;
    @Autowired IUsuarioRepository _usuarioRepository;
    
    
    private void salvarSession(Pedido pedido){
        _request.getSession().setAttribute("pedido", pedido);
    }
    
    private Pedido obterSession() {
        Object p = _request.getSession().getAttribute("pedido");        
        return p == null ? criarPedido() : (Pedido)p;    
    }
    
    public Endereco obterEnderecoEntrega(){
        Pedido pedido = obterPedido();
        
        if (pedido.getEnderecoEntrega() != null)
            return pedido.getEnderecoEntrega();
        
        return pedido.getCliente().getEnderecos().get(0);
    }
    
    private Pedido criarPedido(){
        
        Pedido pedido = new Pedido();
        pedido.setNumero(System.currentTimeMillis());        
                
        Usuario usuario = _usuarioService.obterUsuarioLogado();
        
        pedido.setCliente(usuario.getCliente());
        
        //_repository.save(pedido);
        
        salvarSession(pedido);
        
        return pedido;
    }
    
    public Pedido obterPedido() {        
        return obterSession();
    }
    
    public void indicarEndereco(Endereco endereco) {
        
        Pedido pedido = obterPedido();
        
        _endRepository.save(endereco);        
        
        pedido.setEnderecoEntrega(endereco);
        
        //_repository.save(pedido);
        
        salvarSession(pedido);
    }
    
    public void indicarFormaPagamento(FormaPagamento forma) {
        
        Pedido pedido = obterPedido();    
        
        pedido.setFormaPagamento(forma);
        
        //_repository.save(pedido);
        
        salvarSession(pedido);
    }
    
    public void finalizarPedido() {
    
        Pedido pedido = obterPedido();    
        pedido.setData(new Date());
        _repository.save(pedido);
        
        _request.getSession().removeAttribute("carrinho");
        _request.getSession().removeAttribute("pedido");        
    }
}