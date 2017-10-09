package com.next.library.controller;

import com.next.library.model.Carrinho;
import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author roger
 */
@Controller
public class MainController {

    IProdutoRepository _repository;

    protected MainController(IProdutoRepository repository) {
        _repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(HttpServletRequest request) throws IOException, URISyntaxException {
        request.getSession().setAttribute("carrinho", new Carrinho());      
        return "index";
    }
}
