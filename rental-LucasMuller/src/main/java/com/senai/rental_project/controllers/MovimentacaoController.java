package com.senai.rental_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.rental_project.moldels.Movimentacao;
import com.senai.rental_project.services.MovimentacaoService;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {
    
    @Autowired
    private MovimentacaoService movimentacaoService;

    @GetMapping("/contar-movimentacaos")
    public Long contarMovimentacaos() {
        return movimentacaoService.contarMovimentacaos();
    }

    @PostMapping("/salvar-movimentacao")
    public Movimentacao cadastrarMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.cadastrarMovimentacao(movimentacao);
    }
    
    @DeleteMapping("/deletar-movimentacao/{id}")
    public String deletarMovimentacao(@PathVariable Integer id) {
        if(movimentacaoService.deletarMovimentacao(id)) {
            return "Movimentação removido com sucesso";
        }
        return "Falha ao remover movimentação";
    }

    @GetMapping("/buscar-movimentacaos/{id}")
    public Movimentacao buscMovimentacao(@PathVariable Integer id) {
        return movimentacaoService.buscarMovimentacao(id);
    }

    @GetMapping("/listar-movimentacaos")
    public List<Movimentacao> listaMovimentacaos() {
        return movimentacaoService.listaMovimentacaos();
    }

    @PutMapping("/atualizar-movimentacao/{id}")
    public String atualizarMovimentacao(@PathVariable Integer id, @RequestBody Movimentacao movimentacao) {
        if(movimentacaoService.atualizarMovimentacao(id, movimentacao) != null) {
            return "Movimentação atualizado com sucesso.";
        }
        return "Falha ao atualizar o movimentação.";
    }
}
