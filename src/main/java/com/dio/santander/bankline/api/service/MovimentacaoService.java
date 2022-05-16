package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovaMovimentacao;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final CorrentistaRepository correntistaRepository;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, CorrentistaRepository correntistaRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.correntistaRepository = correntistaRepository;
    }

    public void save(NovaMovimentacao novaMovimentacao) {

        Movimentacao movimentacao = new Movimentacao();

        Double valor = novaMovimentacao.getTipo() ==
                MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;
        movimentacao.setValor(valor);
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdCorrentista(novaMovimentacao.getIdCorrentista());
        movimentacao.setTipo(novaMovimentacao.getTipo());

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdCorrentista()).orElse(null);
        if(correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }

        movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }
}
