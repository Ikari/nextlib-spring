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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String detalharProdutos(@RequestParam int id, Model model){
        
        Produto produtos = _repository.findOne(id);
                
        model.addAttribute("produtos", produtos);
        
        return "detalhes :: produto";
    }
    
    @RequestMapping(value="/adicionar-produto", method=RequestMethod.POST)    
    public @ResponseBody String carrinho(@RequestBody Produto produto, HttpServletRequest request, Model model){
        
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if (carrinho == null)
            carrinho = new Carrinho();
        
        carrinho.AdicionarProduto(_repository.findOne(produto.getId()), 1);
        
        request.getSession().setAttribute("carrinho", carrinho);
                
        carrinho.getProdutos().forEach(p -> System.out.println(p.getProduto().getNome()));
        
        return "{}";
    }
    
    @RequestMapping(value="/carrinho", method=RequestMethod.GET)
    public String carrinho(HttpServletRequest request, Model model){
        
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if (carrinho == null)
            carrinho = new Carrinho();
        
        model.addAttribute("carrinho", carrinho);
        
        return "carrinho :: carrinho";
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
