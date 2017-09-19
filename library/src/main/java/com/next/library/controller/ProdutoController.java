/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roger
 */
@Controller
public class ProdutoController {
    
    IProdutoRepository _repository;
    
    protected ProdutoController(IProdutoRepository repository){
        _repository = repository;
    }
    
    @RequestMapping(value="/produtos", method=RequestMethod.GET)
    public String listarProdutos(Model model){
        
        Iterable<Produto> produtos = _repository.findAll();
        
        model.addAttribute("produtos", produtos);
        
        return "listas :: produto";
    }
    
    @RequestMapping(value="/detalhe-produto", method=RequestMethod.GET)
    public String detalharProdutos(int produto){
        
//        Iterable<Produto> produtos = _repository.findAll();
//                
//        model.addAttribute("produtos", produtos);
        
        return "listas :: produto";
    }
    
    @RequestMapping(value="/carrinho", method=RequestMethod.GET)
    public String carrinho(HttpServletRequest request, Model model){
        
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if (carrinho != null)
            System.out.print("carrinho recuperado da session");
        
//        Iterable<Produto> produtos = _repository.findAll();
//                
//        model.addAttribute("produtos", produtos);
        
        return "listas :: produto";
    }
    
    @RequestMapping(value="/produto", method=RequestMethod.GET)
    public String index(Model model){
        
        model.addAttribute("produto", new Produto());
        
        return "cadastros :: produto";
    }
    
    @RequestMapping(value="/cadastrarProduto", method=RequestMethod.POST)
    public String cadastrarCliente(@ModelAttribute(value="produto") Produto produto){
        
        System.out.printf(
                "PRODUTO %n "
                + "[nome = %s] %n "
                + "[descricao = %s] %n "
                + "[preço = %s] %n "
                + "[ean = %s] %n", 
                produto.getNome(), 
                produto.getDescricao(), 
                produto.getPreco(), 
                produto.getEan());
               
        _repository.save(produto);
        
        
        return "cadastros :: produto";
    }
}
