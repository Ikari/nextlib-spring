package com.next.library.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
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
    
    @RequestMapping
    public ModelAndView index(HttpServletRequest request) throws IOException, URISyntaxException {                
        return new ModelAndView("redirect:/produtos");
    }
}
