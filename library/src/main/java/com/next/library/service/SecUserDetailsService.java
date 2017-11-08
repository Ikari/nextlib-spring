package com.next.library.service;

import com.next.library.model.Usuario;
import com.next.library.model.SecUserDetails;
import com.next.library.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author roger
 */
@Component
public class SecUserDetailsService implements UserDetailsService {
    
    @Autowired private IUsuarioRepository _repository;
    @Autowired private UsuarioService _service; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Usuario usuario = _repository.findUsuarioByEmail(username);
        
        if (usuario == null)
            throw new UsernameNotFoundException(username);
        
        _service.logarUsuario(usuario);
        
        return new SecUserDetails(usuario);
    }
}
