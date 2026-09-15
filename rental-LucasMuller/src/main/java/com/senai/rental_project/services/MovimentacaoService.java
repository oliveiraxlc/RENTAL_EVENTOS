package com.senai.rental_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.rental_project.moldels.Movimentacao;
import com.senai.rental_project.repositories.MovimentacaoRepository;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    public Long contarMovimentacaos() {
        return movimentacaoRepository.count();
    }

    public Movimentacao buscarMovimentacao(Integer id) {
        return movimentacaoRepository.findById(id).get();
    }

    public List<Movimentacao> listaMovimentacaos() {
        return movimentacaoRepository.findAll();
    }

    public Boolean deletarMovimentacao(Integer id) {
        if(movimentacaoRepository.existsById(id)) {
            movimentacaoRepository.deleteById(id);
            return true;
        }  
        return false;  
    }

    public Movimentacao cadastrarMovimentacao(Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }

      public Movimentacao atualizarMovimentacao(Integer id, Movimentacao movimentacao) {
        Movimentacao movimentacaoRecuperado = buscarMovimentacao(id);
        if (movimentacaoRecuperado != null) {
            movimentacaoRecuperado.setId(movimentacao.getId());
            if (movimentacao.getDataMovimentacao() != null) {
                movimentacaoRecuperado.setDataMovimentacao(movimentacao.getDataMovimentacao());
            }
            return movimentacaoRepository.save(movimentacaoRecuperado);
        }
        return null;
    }
}
