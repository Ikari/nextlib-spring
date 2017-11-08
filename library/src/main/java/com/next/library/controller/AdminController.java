/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.next.library.controller;

import com.next.library.model.Produto;
import com.next.library.repository.IProdutoExcertpRepository;
import com.next.library.repository.IProdutoRepository;
import java.io.IOException;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired private IProdutoRepository produtoRepository;
    @Autowired private IProdutoExcertpRepository produtoRepositoryDto;
    
    @RequestMapping("/produto/lista")
    public ModelAndView listaProdutos(){
        return new ModelAndView("/admin/produto/lista").addObject("produtos", produtoRepositoryDto.findAll());
    }
    
    @RequestMapping("/produto/cadastro")
    public ModelAndView cadastro(){        
        return new ModelAndView("/admin/produto/cadastro").addObject("produto", new Produto());        
    }
    
    @RequestMapping("/produto/cadastro/{id}")
    public ModelAndView editar(@PathVariable("id") ObjectId id){                
        return new ModelAndView("/admin/produto/cadastro").addObject("produto", produtoRepository.findOne(id));        
    }
    
    @RequestMapping(value="/produto/cadastrar", method=RequestMethod.POST)
    public ModelAndView cadastrar(
           @ModelAttribute("produto") @Valid Produto produto,            
           BindingResult binding,
           RedirectAttributes attributes,
           @RequestParam("arquivo") MultipartFile arquivo,
           @RequestParam("thumb") MultipartFile thumb
           ){        
        
        if (arquivo.isEmpty()){
            attributes.addFlashAttribute("msgErro", "Erro ao carregar a imagem.");
            return new ModelAndView("/admin/produto/cadastro");
        }
                
        if (binding.hasErrors())
            return new ModelAndView("/admin/produto/cadastro");
        
        try {            
            produto.setImagem(arquivo.getBytes());
            produto.setThumbnail(thumb.getBytes());
            produtoRepository.save(produto);
        }
        catch(IOException ex){
            attributes.addFlashAttribute("msgErro", "Erro ao salvar o produto.");
            return new ModelAndView("/admin/produto/cadastro");
        }
        
        attributes.addFlashAttribute("msgSucesso", "Produto cadastrado com sucesso!");
        
        return new ModelAndView("redirect:/produtos");        
    }
}
