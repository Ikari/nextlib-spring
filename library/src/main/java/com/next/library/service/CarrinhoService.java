package com.next.library.service;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import javax.servlet.http.HttpServletRequest;
import org.bson.types.ObjectId;
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
public class CarrinhoService {
    
    @Autowired
    HttpServletRequest _request;
    
    @Autowired
    private IProdutoRepository _repository;
        
    private Carrinho criarCarrinho(){
        
        Carrinho carrinho = new Carrinho();
        _request.getSession().setAttribute("carrinho", carrinho);
        
        return carrinho;
    }
    
    public Carrinho obterCarrinho(){        
        
        Carrinho carrinho = (Carrinho)_request.getSession().getAttribute("carrinho");        
        
        return carrinho == null ? criarCarrinho() : carrinho;
    }
    
    public Carrinho adicionarProduto(ObjectId id, int quantidade){
        
        Produto produto = _repository.findOne(id);
        
        return adicionarProduto(produto, quantidade);
    }
    
    public Carrinho adicionarProduto(Produto produto, int quantidade){
        
        Carrinho carrinho = obterCarrinho();
        carrinho.AdicionarProduto(produto, quantidade);
        _request.getSession().setAttribute("carrinho", carrinho);
        
        return carrinho;
    }
}
