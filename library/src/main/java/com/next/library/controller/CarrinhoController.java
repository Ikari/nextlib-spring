package com.next.library.controller;

import com.next.library.model.Produto;
import com.next.library.service.CarrinhoService;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roger.roliveira
 */
@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
    
    @Autowired
    CarrinhoService service;    
            
    @RequestMapping
    public ModelAndView carrinho(){        
        return new ModelAndView("carrinho/carrinho").addObject("carrinho", service.obterCarrinho());
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
