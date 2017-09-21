package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roger
 */
@Controller
public class MainController {
    
    IProdutoRepository _repository;
    
    protected MainController(IProdutoRepository repository){
        _repository = repository;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(HttpServletRequest request) throws IOException, URISyntaxException {        
        
        request.getSession().setAttribute("carrinho", new Carrinho());  
        
        //IOUtils.toByteArray(ClassLoader.class.getResourceAsStream("como-a-mente-funciona.jpg"))
        
        Path path01 = Paths.get("C:/Users/roger.roliveira/Downloads", "como-a-mente-funciona.jpg");
        Path path02 = Paths.get("C:/Users/roger.roliveira/Downloads", "do-que-e-feito-o-pensamento.jpg");
        Path path03 = Paths.get("C:/Users/roger.roliveira/Downloads", "o-orfanato-da-srta-peregrine.jpg");

        _repository.save(
                new Produto(
                    1, 
                    "Como a mente funciona", 
                    "Como as crianças aprendem sobre o mundo que as rodeia? "
                    + "Pinker mostra como podemos estar bem próximos de uma das últimas fronteiras do conhecimento - "
                    + "a mente humana.",
                    47.9,
                Files.readAllBytes(path01)));        
        
        _repository.save(
                new Produto(
                    2, 
                    "Do que é feito o pensamento", 
                    "Combinando alguns de seus livros anteriores como O instinto da linguagem (1994) e "
                    + "Como a mente funciona (1998), Steven Pinker encontra na linguagem uma janela para uma "
                    + "possível explicação da natureza humana.",
                    52.9,
                Files.readAllBytes(path02)));        
        
        _repository.save(
                new Produto(
                    3, 
                    "O Orfanato da Srta. Peregrine Para Crianças Peculiares", 
                    "O orfanato da Srta. Peregrine para Crianças Peculiares é um romance que "
                    + "mistura ficção e fotografia. A história começa com uma tragédia familiar que lança Jacob, "
                            + "um rapaz de 16 anos, em uma jornada até uma ilha remota na costa do País de Gales.",
                    13.9,
                Files.readAllBytes(path03)));        
        
        return "index";
    }
}
