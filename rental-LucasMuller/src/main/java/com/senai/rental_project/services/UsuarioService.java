package com.senai.rental_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.rental_project.moldels.Usuario;
import com.senai.rental_project.repositories.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Long contarUsuarios() {
        return usuarioRepository.count();
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public List<Usuario> listaUsuarios() {
        return usuarioRepository.findAll();
    }

    public Boolean deletarUsuario(Long id) {
        if(usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }  
        return false;  
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

      public Usuario atualizarUsuario(Long id, Usuario usuario) {
        Usuario usuarioRecuperado = buscarUsuario(id);
        if (usuarioRecuperado != null) {
            usuarioRecuperado.setId(usuario.getId());
            if (usuario.getNome() != null) {
                usuarioRecuperado.setNome(usuario.getNome());
            }
            return usuarioRepository.save(usuarioRecuperado);
        }
        return null;
    }

}
