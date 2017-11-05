package com.next.library.service;

import com.next.library.model.Cliente;
import com.next.library.model.Endereco;
import com.next.library.model.Usuario;
import com.next.library.repository.IUsuarioRepository;
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
        cliente.adicionarEndereco(endereco);
        cadastrarUsuarioFase2(cliente);
    }
    
    public void finalizarCadastro(){
        Usuario usuario = (Usuario)_request.getSession().getAttribute("usuario-temp");
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
