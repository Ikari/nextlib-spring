package com.next.library.controller;

import com.next.library.model.Cliente;
import com.next.library.model.Usuario;
import com.next.library.model.Endereco;
import com.next.library.service.UsuarioService;
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
            
    @Autowired UsuarioService service;
    
    @RequestMapping
    public ModelAndView login(){                
        return new ModelAndView("/login/login");        
    }
        
    @RequestMapping("/login-error")
    public ModelAndView loginError(){        
        return new ModelAndView("/login/login-error");        
    }   
    
    @RequestMapping("/cadastro/1")
    public ModelAndView cadastroUsuario(){               
        return new ModelAndView("/login/cadastro-usuario").addObject("usuario", service.obterUsuarioCadastro());
    }
    
    @RequestMapping("/cadastro/2")
    public ModelAndView cadastroCliente(){        
        return new ModelAndView("/login/cadastro-cliente").addObject("cliente", service.obterClienteCadastro());
    }
    
    @RequestMapping("/cadastro/3")
    public ModelAndView cadastroEndereco(){        
        return new ModelAndView("/login/cadastro-endereco").addObject("endereco", service.obterEnderecoCadastro());
    }
    
    @RequestMapping(value="/cadastrar/1", method=RequestMethod.POST)
    public ModelAndView cadastrarUsuario(
           @ModelAttribute("usuario") @Valid Usuario usuario,
           BindingResult binding,
           RedirectAttributes attributes){        
        
        if (binding.hasErrors())
            return new ModelAndView("/login/cadastro");
        
        service.cadastrarUsuarioFase1(usuario);
        
        return new ModelAndView("redirect:/login/cadastro/2");
    }
    
    @RequestMapping(value="/cadastrar/2", method=RequestMethod.POST)
    public ModelAndView cadastrarCliente(
           @ModelAttribute("cliente") @Valid Cliente cliente,
           BindingResult binding,
           RedirectAttributes attributes){        
        
        if (binding.hasErrors())
            return new ModelAndView("/login/cadastro");
        
        service.cadastrarUsuarioFase2(cliente);
        
        return new ModelAndView("redirect:/login/cadastro/3");
    }
    
    @RequestMapping(value="/cadastrar/3", method=RequestMethod.POST)
    public ModelAndView cadastrarEndereco(
           @ModelAttribute("endereco") @Valid Endereco endereco,
           BindingResult binding,
           RedirectAttributes attributes){        
        
        if (binding.hasErrors())
            return new ModelAndView("/login/cadastro");
        
        service.cadastrarUsuarioFase3(endereco);
        service.finalizarCadastro();
        
        return new ModelAndView("redirect:/login");        
    }
}
