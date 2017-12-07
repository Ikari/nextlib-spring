/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.controller;

import com.next.library.model.Endereco;
import com.next.library.model.Usuario;
import com.next.library.repository.IPedidoRepository;
import com.next.library.service.ClienteService;
import com.next.library.service.UsuarioService;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
 * @author roger
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired ClienteService service;    
    @Autowired UsuarioService userService;
    @Autowired IPedidoRepository pedidoRepository;
    
    @RequestMapping(value="/adicionar-endereco", method=RequestMethod.POST)    
    public ModelAndView adicionarProduto(
            @ModelAttribute("endereco") @Valid Endereco endereco,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        
        if (bindingResult.hasErrors())
            return new ModelAndView("redirect:/login");
          
        
        
        //service.cadastrarEndereco(produto.getId(), 1);
        
        return new ModelAndView("redirect:/carrinho");
    }
    
    @RequestMapping("/pedidos")
    public ModelAndView pedidos(){        
        
        Usuario usuario = userService.obterUsuarioLogado();
        
        return new ModelAndView("cliente/pedidos").addObject("pedidos", pedidoRepository.findPedidoByCliente(usuario.getCliente(), new Sort(Sort.Direction.DESC, "data")));
    }
    
    @RequestMapping("/pedido/{id}")
    public ModelAndView detalhe(@PathVariable("id") ObjectId id){                
        return new ModelAndView("cliente/detalhes").addObject("pedido", pedidoRepository.findOne(id));
    }
}
