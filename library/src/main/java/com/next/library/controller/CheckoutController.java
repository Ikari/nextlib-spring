package com.next.library.controller;

import com.next.library.dtos.Pagamento;
import com.next.library.model.Endereco;
import com.next.library.model.Pedido;
import com.next.library.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author roger
 */
@Controller
@RequestMapping("/checkout")
public class CheckoutController {
    
    @Autowired CheckoutService service;    
    
    @RequestMapping
    public ModelAndView index(){
        service.obterPedido();
        return new ModelAndView("checkout/index");
    }
    
    @RequestMapping("/1")
    public ModelAndView endereco(){             
        return new ModelAndView("checkout/endereco").addObject("endereco", service.obterEnderecoEntrega());
    }
    
    @RequestMapping("/2")
    public ModelAndView pagamento(){        
        return new ModelAndView("checkout/pagamento").addObject("pagamento", new Pagamento());
    }
    
    @RequestMapping("/3")
    public ModelAndView resumo(){        
        return new ModelAndView("checkout/resumo").addObject("pedido", service.obterPedido());
    }
    
    @RequestMapping("/pedido")
    public ModelAndView pedido(){        
        
        Pedido pedido = service.obterPedido();
        
        service.encerrarPedido();
        
        return new ModelAndView("checkout/pedido").addObject("pedido", pedido);
    }
    
    @RequestMapping(value = "/etapa/1", method=RequestMethod.POST)
    public @ResponseBody String salvarEndereco(
            @ModelAttribute("endereco") Endereco endereco,
            BindingResult result,
            RedirectAttributes attr
            ) {        
        
        service.indicarEndereco(endereco);
        
        return "{ }";
    }
    
    @RequestMapping(value = "/etapa/2", method=RequestMethod.POST)
    public @ResponseBody String salvarPagamento(
            @ModelAttribute("pagamento") Pagamento pagamento,            
            BindingResult result,
            RedirectAttributes attr
            ) {        
                
        //valida os dados do cartão, yada yada yada...
        
        service.indicarFormaPagamento(pagamento.getFormaPagamento());
        
        return "{ }";
    }
    
    @RequestMapping(value = "/finalizar", method=RequestMethod.POST)
    public ModelAndView finalizar() {        
                
        service.finalizarPedido();        
        
        return new ModelAndView("redirect:/checkout/pedido");
    }
}
