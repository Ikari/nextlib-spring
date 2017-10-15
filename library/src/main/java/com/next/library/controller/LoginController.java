package com.next.library.controller;

import com.next.library.model.Cliente;
import com.next.library.service.ClienteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/login")
public class LoginController {
            
    @Autowired
    ClienteService service;
    
    @RequestMapping
    public ModelAndView login(){                
        return new ModelAndView("/login/login");        
    }
    
    @RequestMapping("/login-error")
    public ModelAndView loginError(){        
        return new ModelAndView("/login/login-error");        
    }   
    
    @RequestMapping("/cadastro")
    public ModelAndView cadastro(){        
        return new ModelAndView("/login/cadastro");        
    }
    
    @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
    public ModelAndView cadastrar(
           @ModelAttribute("cliente") @Valid Cliente cliente,
           BindingResult binding,
           RedirectAttributes attributes){        
        
        if (binding.hasErrors())
            return new ModelAndView("/login/cadastro");
        
        service.cadastrarCliente(cliente);
        
        return new ModelAndView("redirect:/login");        
    }
}
