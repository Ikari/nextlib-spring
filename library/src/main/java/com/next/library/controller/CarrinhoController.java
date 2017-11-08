package com.next.library.controller;

import com.next.library.model.*;
import com.next.library.repository.IProdutoRepository;
import com.next.library.service.*;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roger.roliveira
 */
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {
    
    @Autowired CarrinhoService service;    
    @Autowired UsuarioService usuarioService;
    @Autowired IProdutoRepository produtoRepository;
            
    @RequestMapping
    public ModelAndView carrinho(){        
                
        Usuario usuario = usuarioService.obterUsuarioLogado();
        
        if (usuario == null)
            return new ModelAndView("carrinho/carrinho")
                .addObject("carrinho", service.obterCarrinho())
                .addObject("usuario", null)
                .addObject("cliente", null)
                .addObject("endereco", null)
                ;
        
        Cliente cliente = usuario.getCliente();
        Endereco endereco = cliente.getEnderecos().get(0);
                
        return new ModelAndView("carrinho/carrinho")
                .addObject("carrinho", service.obterCarrinho())
                .addObject("usuario", usuario)
                .addObject("cliente", cliente)
                .addObject("endereco", endereco)
                ;
    }

    @RequestMapping(value="/adicionar/{id}")
    public boolean adicionarProduto(
            @PathVariable("id") @Valid ObjectId id){
                
        Produto produto = produtoRepository.findOne(id);
               
        if (produto == null)
            return false;
        
        service.adicionarProduto(produto, 1);
        
        return true;
    }
    
    @RequestMapping(value="/adicionar", method=RequestMethod.POST)    
    public ModelAndView adicionarProduto(
            @ModelAttribute("produto") @Valid Produto produto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        
        if (bindingResult.hasErrors())
            return new ModelAndView("redirect:/produtos");
                
        if (produto.getId() == null)
            return new ModelAndView("redirect:/carrinho");
                
        service.adicionarProduto(produto.getId(), 1);
        
        return new ModelAndView("redirect:/carrinho");
    }
        
    @RequestMapping("/remover/{id}")    
    public ModelAndView removerProduto(@PathVariable("id") ObjectId produtoId){
                       
        service.removerProduto(produtoId);
        
        return new ModelAndView("redirect:/carrinho");
    }
}
