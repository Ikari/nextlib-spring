package com.next.library.service;

import com.next.library.model.Cliente;
import com.next.library.model.SecUserDetails;
import com.next.library.repository.IClienteRepository;
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
    
    @Autowired
    private IClienteRepository _repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = _repository.findClienteByUsername(username);
        if (cliente == null)
            throw new UsernameNotFoundException(username);
        
        UserDetails details = new SecUserDetails(cliente);
        return details;
    }
}
