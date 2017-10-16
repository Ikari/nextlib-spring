package com.next.library.controller;

import com.next.library.model.Cliente;
import com.next.library.model.Regra;
import com.next.library.repository.IClienteRepository;
import com.next.library.repository.IRegraRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
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
    
    @Autowired private IClienteRepository clienteRepository;
    @Autowired private IRegraRepository regraRepository;
    
    @RequestMapping
    public ModelAndView index(HttpServletRequest request) throws IOException, URISyntaxException {
        
        criarRegras();
        criarAdmin();
        
        return new ModelAndView("redirect:/produtos");
    }
    
    private void criarRegras(){
        
        if (regraRepository.findRegraByRegra("ADMINISTRADOR") == null)        
            regraRepository.save(new Regra("ADMINISTRADOR"));
        if (regraRepository.findRegraByRegra("USUARIO") == null)        
            regraRepository.save(new Regra("USUARIO"));
    }
    
    private void criarAdmin(){
        
        Cliente c = clienteRepository.findClienteByUsername("admin");
        
        if (c == null){
            Cliente cliente = new Cliente("admin", "admin", "admin@zmail.com");
        
            List<Regra> regras = new ArrayList<>();
            regras.add(regraRepository.findRegraByRegra("ADMINISTRADOR"));

            cliente.setRegras(regras);

            clienteRepository.save(cliente);
        }
    }
}
