package com.next.library.controller;

import com.next.library.model.Produto;
import com.next.library.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private IProdutoRepository _repository;
    
    protected ProdutoController(IProdutoRepository repository){
        _repository = repository;
    }
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String listar(Model model){
        
        Iterable<Produto> produtos = _repository.findAll();
        
        model.addAttribute("produtos", produtos);
        
        return "listas :: produto";
    }
    
    @RequestMapping(value="/detalhe", method=RequestMethod.GET)
    public String detalhar(@RequestParam int id, Model model){
        
        Produto produtos = _repository.findOne(id);
                
        model.addAttribute("produtos", produtos);
        
        return "detalhes :: produto";
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