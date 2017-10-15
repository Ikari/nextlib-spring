package com.next.library.controller;

import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private IProdutoRepository _repository;
        
    @RequestMapping
    public ModelAndView listar(){        
        return new ModelAndView("produto/produtos").addObject("produtos", _repository.findAll());
    }
    
    @RequestMapping("/{id}")
    public ModelAndView detalhar(@PathVariable("id") int id){        
        return new ModelAndView("produto/detalhes").addObject("produto", _repository.findOne(id));
    }
       
    
    @RequestMapping(value="/exibir", method=RequestMethod.GET)
    public String index(Model model){
        
        model.addAttribute("produto", new Produto());
        
        return "cadastros :: produto";
    }
    
    @RequestMapping(value="/cadastrar", method=RequestMethod.POST)
    public String cadastrar(@ModelAttribute(value="produto") Produto produto){
                      
        _repository.save(produto);        
        
        return "cadastros :: produto";
    }
}