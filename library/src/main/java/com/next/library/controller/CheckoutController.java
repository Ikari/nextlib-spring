package com.next.library.controller;

import com.next.library.dtos.CartaoCredito;
import com.next.library.model.Endereco;
import com.next.library.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    
    @Autowired CarrinhoService service;    
        
    @RequestMapping("/fase1")
    public ModelAndView endereco(){        
        return new ModelAndView("checkout/endereco").addObject("endereco", new Endereco());
    }
    
    @RequestMapping("/fase2")
    public ModelAndView pagamento(){        
        return new ModelAndView("checkout/pagamento").addObject("cartao", new CartaoCredito());
    }
    
    @RequestMapping("/fase3")
    public ModelAndView resumo(){        
        return new ModelAndView("checkout/resumo");
    }
    
    @RequestMapping("/pedido")
    public ModelAndView pedido(){        
        return new ModelAndView("checkout/pedido");
    }
}
