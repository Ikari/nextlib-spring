/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.controller;

import com.next.library.repository.IPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rooliveira09
 */
@Controller
@RequestMapping("/relatorio")
public class RelatorioController {
    
    @Autowired IPedidoRepository _repository;   
    
    @RequestMapping("/pedidos")
    public ModelAndView carrinho(){        
        return new ModelAndView("relatorios/pedidos").addObject("pedidos", _repository.findAll());
    }
}
