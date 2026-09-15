package com.senai.rental_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental_project.models.Login;
import com.senai.rental_project.models.Usuario;
import com.senai.rental_project.services.UsuarioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login dto) {
        String token = usuarioService.realizarLogin(dto);
        return ResponseEntity.ok(token);
    }


    @GetMapping("/contar-usuarios")
    public Long contarUsuarios() {
        return usuarioService.contarUsuarios();
    }

    @PostMapping("/salvar-usuario")
    public Usuario cadastrarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.cadastrarUsuario(usuario);
    }
    
    @DeleteMapping("/deletar-usuario/{id}")
    public String deletarUsuario(@PathVariable Long id) {
        if(usuarioService.deletarUsuario(id)) {
            return "Usuário removido com sucesso";
        }
        return "Falha ao remover usuário";
    }

    @GetMapping("/buscar-usuarios/{id}")
    public Usuario buscUsuario(@PathVariable Long id) {
        return usuarioService.buscarUsuario(id);
    }

    @GetMapping("/listar-usuarios")
    public List<Usuario> listaUsuarios() {
        return usuarioService.listaUsuarios();
    }

    @PutMapping("/atualizar-usuario/{id}")
    public String atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        if(usuarioService.atualizarUsuario(id, usuario) != null) {
            return "Usuário atualizado com sucesso.";
        }
        return "Falha ao atualizar o usuário.";
    }
}
