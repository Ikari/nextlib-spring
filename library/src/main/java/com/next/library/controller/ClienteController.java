package com.next.library.controller;

import com.next.library.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roger
 */
@Controller
public class ClienteController {
    
    @RequestMapping(value="/cliente", method=RequestMethod.GET)
    public String index(Model model){
        
        model.addAttribute("cliente", new Cliente());
        
        return "cadastros :: cliente";
    }
    
    @RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
    public String cadastrarCliente(@ModelAttribute(value="cliente") Cliente cliente){
        
        System.out.printf("CLIENTE /n [nome = %s] /n [nascimento = %s] /n [cpf = %s] /n [rg = %s] /n", cliente.getNome(), cliente.getDataNascimento(), cliente.getCpf(), cliente.getRg());
               
        
        return "cadastros :: cliente";
    }
}
