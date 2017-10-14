package com.next.library.controller;

import com.next.library.model.Cliente;
import com.next.library.repository.IClienteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    
    @Autowired
    private IClienteRepository clienteRepository;
        
    @RequestMapping
    public ModelAndView login(){        
        
        //clienteRepository.save(new Cliente("teste", "123"));
        
        return new ModelAndView("/login/login");        
    }
    
    @RequestMapping("/login-error")
    public ModelAndView loginError(){        
        
        return new ModelAndView("/login/login-error");        
    }   
    
}
