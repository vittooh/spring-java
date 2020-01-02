package com.example.learning.api.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario getUsarioByUsername(String username) {
        return usuarioRepository.findUsuarioByUser(username);
    }

}
