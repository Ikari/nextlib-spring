package com.next.library.controller;

import com.next.library.model.Carrinho;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author roger
 */
@Controller
public class MainController {
        
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index(HttpServletRequest request) throws IOException, URISyntaxException {        
        
        request.getSession().setAttribute("carrinho", new Carrinho());                 
        
        return "index";
    }
}
