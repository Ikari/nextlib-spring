/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.controller;

import com.next.library.model.Pedido;
import com.next.library.repository.IPedidoRepository;
import java.util.Date;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/backoffice")
public class BackofficeController {
    @Autowired IPedidoRepository _repository;   
    
    @RequestMapping("/pedidos")
    public ModelAndView pedidos(){        
        return new ModelAndView("admin/boffice/pedidos").addObject("pedidos", _repository.findAll(new Sort(Sort.Direction.DESC, "data")));
    }
    
    @RequestMapping("/pedido/{id}")
    public ModelAndView pedido(@PathVariable ObjectId id){        
        return new ModelAndView("admin/boffice/pedido").addObject("pedido", _repository.findOne(id));
    }
    
    @RequestMapping(value="/salvar", method=RequestMethod.POST)
    public ModelAndView atualizar(
            @ModelAttribute(value="pedido") Pedido pedido,
            RedirectAttributes attributes
    ){                      
        long numeroPedido = atualizarStatusPedido(pedido.getId(), pedido.getEstado());        
        attributes.addFlashAttribute("msgSucesso", String.format("Pedido nº %s alterado com sucesso.", numeroPedido));
        return new ModelAndView("redirect:/backoffice/pedidos");   
    }
        
    private long atualizarStatusPedido(ObjectId id, int estado){
        Pedido pedido = _repository.findOne(id);
        pedido.setEstado(estado);
        pedido.setUltimaAtualizacao(new Date());
        _repository.save(pedido);
        return pedido.getNumero();
    }
}
