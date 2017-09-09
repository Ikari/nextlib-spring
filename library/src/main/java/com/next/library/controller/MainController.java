package com.next.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author roger
 */
@Controller
public class MainController {
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
