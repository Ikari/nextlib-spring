package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author roger.roliveira
 */
@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
    
    @Autowired
    private IProdutoRepository _repository;
        
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String carrinho(HttpServletRequest request, Model model){
        
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if (carrinho == null)
            carrinho = new Carrinho();
        
        model.addAttribute("carrinho", carrinho);
        
        return "carrinho :: carrinho";
    }
    
    @RequestMapping(value="/adicionar", method=RequestMethod.POST)    
    public @ResponseBody String adicionarProdutoAoCarrinho(@RequestBody Produto produto, HttpServletRequest request, Model model){
        
        Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
        
        if (carrinho == null)
            carrinho = new Carrinho();
        
        carrinho.AdicionarProduto(_repository.findOne(produto.getId()), 1);
        
        request.getSession().setAttribute("carrinho", carrinho);
                
        carrinho.getProdutos().forEach(p -> System.out.println(p.getProduto().getNome()));
        
        return "{}";
    }
}
