package br.com.faunora.services;

import br.com.faunora.infra.exceptions.NenhumUsuarioEncontradoException;
import br.com.faunora.infra.exceptions.UsuarioNaoEncontradoException;
import br.com.faunora.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsuarioNaoEncontradoException("usuário não encontrado"));
    }
}