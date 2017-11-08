package com.next.library.service;

import com.next.library.model.Cliente;
import com.next.library.model.Endereco;
import com.next.library.model.Regra;
import com.next.library.model.Usuario;
import com.next.library.repository.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 *
 * @author roger
 */
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class UsuarioService {
    
    @Autowired HttpServletRequest _request;
    @Autowired IUsuarioRepository _repository;
    @Autowired IClienteRepository _repositoryCliente;
    @Autowired IEnderecoRepository _repositoryEndereco;
    @Autowired IRegraRepository _repositoryRegra;
    
    public Usuario obterUsuarioCadastro(){        
        Object usuario = _request.getSession().getAttribute("usuario-temp");        
        return usuario == null? new Usuario() : (Usuario)usuario;
    }
    
    public Cliente obterClienteCadastro(){        
        Object usuario = _request.getSession().getAttribute("usuario-temp");            
        Cliente cliente = usuario == null ? new Cliente() : ((Usuario)usuario).getCliente();        
        return cliente == null ? new Cliente() : cliente;
    }
    
    public Endereco obterEnderecoCadastro(){        
        Object usuario = _request.getSession().getAttribute("usuario-temp");        
        
        if (usuario == null)
            return new Endereco();
        
        Cliente cliente = ((Usuario)usuario).getCliente();
        
        if (cliente == null || cliente.getEnderecos() == null || cliente.getEnderecos().isEmpty())
            return new Endereco();
        
        return cliente.getEnderecos().get(0);
    }
    
    public void cadastrarUsuarioFase1(Usuario usuario){
        _request.getSession().setAttribute("usuario-temp", usuario);
    }
    
    public void cadastrarUsuarioFase2(Cliente cliente){
        Usuario usuario = (Usuario)_request.getSession().getAttribute("usuario-temp");
        usuario.setCliente(cliente);
        cadastrarUsuarioFase1(usuario);
    }
    
    public void cadastrarUsuarioFase3(Endereco endereco){
        Usuario usuario = (Usuario)_request.getSession().getAttribute("usuario-temp");
        Cliente cliente = usuario.getCliente();
        cliente.setEnderecos(new ArrayList<>());
        cliente.adicionarEndereco(endereco);
        cadastrarUsuarioFase2(cliente);
    }
    
    public void finalizarCadastro(){
        
        Usuario usuario = (Usuario)_request.getSession().getAttribute("usuario-temp");        
        Cliente cliente = usuario.getCliente();        
        Endereco endereco = cliente.getEnderecos().get(0);
        
        List<Regra> regras = new ArrayList<>();
        regras.add(_repositoryRegra.findRegraByRegra("USUARIO"));
        
        usuario.setRegras(regras);
        
        _repositoryEndereco.save(endereco);
        _repositoryCliente.save(cliente);
        _repository.save(usuario);
    }
    
    public void logarUsuario(Usuario usuario){
        _request.getSession().setAttribute("usuario", usuario);
    }
    
    public void deslogarUsuario(){
        _request.getSession().removeAttribute("usuario");
    }
    
    public Usuario obterUsuarioLogado(){
        return (Usuario)_request.getSession().getAttribute("usuario");
    }
}
