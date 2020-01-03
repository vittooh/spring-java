package com.example.learning.api.security;

import com.example.learning.api.usuario.Usuario;
import com.example.learning.api.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service(value = "myUserServiceDetail")
public class UserDetailService implements UserDetailsService {


    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Usuario u = usuarioService.getUsarioByUsername(s);

        if (u == null) throw new UsernameNotFoundException("Usuario não encontrado !!  " + s);

        return u;
    }


}
