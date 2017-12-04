package com.next.library.controller;

import com.next.library.model.Usuario;
import com.next.library.model.Regra;
import com.next.library.repository.IUsuarioRepository;
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
    
    @Autowired private IUsuarioRepository usuarioRepository;
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
        
        Usuario u = usuarioRepository.findUsuarioByEmail("admin@zmail.com");
        
        if (u == null){
            Usuario usuario = new Usuario("admin@zmail.com", "admin");
        
            List<Regra> regras = new ArrayList<>();
            regras.add(regraRepository.findRegraByRegra("ADMINISTRADOR"));

            usuario.setRegras(regras);

            usuarioRepository.save(usuario);
        }
    }
}
