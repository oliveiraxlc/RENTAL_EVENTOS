package com.senai.rental_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.senai.rental_project.models.Usuario;
import com.senai.rental_project.models.Login;
import com.senai.rental_project.repositories.UsuarioRepository;
import com.senai.rental_project.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public String realizarLogin(Login dto) {
        // Valida as credenciais via Spring Security
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha())
        );

        // Carrega o usuário autenticado e gera o Token JWT
        UserDetails userDetails = userDetailsService.loadUserByUsername(dto.getLogin());
        return jwtService.generateToken(userDetails);
    }


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
        // Criptografa a senha antes de persistir
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
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