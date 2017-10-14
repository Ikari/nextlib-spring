package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Regra;
import com.next.library.model.Cliente;
import com.next.library.repository.IClienteRepository;
import com.next.library.repository.IRegraRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    IRegraRepository _regraRepository;

    @Autowired
    IClienteRepository _clienteRepository;
    
    @RequestMapping
    public ModelAndView index(HttpServletRequest request) throws IOException, URISyntaxException {
        
        List<Regra> regras = _regraRepository.findAll();
        
//        if (regras == null || regras.isEmpty())
//            adicionarRegras();
//                
//        adicionarUsuarioTeste();
        
        request.getSession().setAttribute("carrinho", new Carrinho());      
        return new ModelAndView("redirect:/produtos");
    }
    
    private void adicionarUsuarioTeste(){
        _clienteRepository.save(new Cliente("teste", "123", "teste@google.com"));
        
        Cliente cliente = _clienteRepository.findClienteByEmail("teste@google.com");
        
        System.out.printf("%s %s", cliente.getId(), cliente.getEmail());
    }
    
    private void adicionarRegras(){
        _regraRepository.save(new Regra("USUARIO"));
        _regraRepository.save(new Regra("ADMINISTRADOR"));
    }
}
