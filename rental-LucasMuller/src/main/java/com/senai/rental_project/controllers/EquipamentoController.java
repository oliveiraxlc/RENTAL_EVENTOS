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

import com.senai.rental_project.moldels.Equipamento;
import com.senai.rental_project.services.EquipamentoService;
@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {
    
    @Autowired
    private EquipamentoService equipamentoService;

    @GetMapping("/contar-equipamentos")
    public Long contarEquipamentos() {
        return equipamentoService.contarEquipamentos();
    }

    @PostMapping("/salvar-equipamento")
    public Equipamento cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        return equipamentoService.cadastrarEquipamento(equipamento);
    }
    
    @DeleteMapping("/deletar-equipamento/{id}")
    public String deletarEquipamento(@PathVariable Integer id) {
        if(equipamentoService.deletarEquipamento(id)) {
            return "Equipamento removido com sucesso";
        }
        return "Falha ao remover equipamento";
    }

    @GetMapping("/buscar-equipamentos/{id}")
    public Equipamento buscEquipamento(@PathVariable Integer id) {
        return equipamentoService.buscarEquipamento(id);
    }

    @GetMapping("/listar-equipamentos")
    public List<Equipamento> listaEquipamentos() {
        return equipamentoService.listaEquipamentos();
    }

    @PutMapping("/atualizar-equipamento/{id}")
    public String atualizarEquipamento(@PathVariable Integer id, @RequestBody Equipamento equipamento) {
        if(equipamentoService.atualizarEquipamento(id, equipamento) != null) {
            return "Equipamento atualizado com sucesso.";
        }
        return "Falha ao atualizar o equipamento.";
    }
}
