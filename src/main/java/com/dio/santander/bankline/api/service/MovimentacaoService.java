package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovaMovimentacaoDTO;
import com.dio.santander.bankline.api.dto.TabelaMovimentacaoCompletaDTO;
import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.dio.santander.bankline.api.repository.MovimentacaoRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;
    private final CorrentistaService correntistaService;

    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository, CorrentistaService correntistaService) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.correntistaService = correntistaService;
    }

    public void save(@Valid NovaMovimentacaoDTO novaMovimentacao) throws IllegalArgumentException {

        Movimentacao movimentacao;
        var correntista = correntistaService.getCorrentistaByIdCorrentista(novaMovimentacao.getIdCorrentista());

        //checa se o correntista existe no banco e vincula ele a movimentacao
        if (correntista.isPresent()) {
            movimentacao = new Movimentacao();
            movimentacao.setCorrentista(correntista.get());
        } else {
            throw new IllegalArgumentException("Correntista " + novaMovimentacao.getIdCorrentista() + " não encontrado!");
        }

        //calcula se o valor é positivo ou negativo, conforme o tipo de movimentacao
        var valorMovimentacao = novaMovimentacao.getTipoMovimentacao() == MovimentacaoTipo.RECEITA ?
                novaMovimentacao.getValorMovimentacao() : novaMovimentacao.getValorMovimentacao() * -1;

        movimentacao.setValor(valorMovimentacao);
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setTipoMovimentacao(novaMovimentacao.getTipoMovimentacao());

        //atualiza o saldo do correntista
        correntista.get().getConta().setSaldo(correntista.get().getConta().getSaldo() + valorMovimentacao);
        correntistaService.updateCorrentista(correntista.get());
        //atualiza a movimentacao
        movimentacaoRepository.save(movimentacao);
    }

    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }

    /**
     * @param idCorrentista Id do correntista que se prentede buscar a lista de movimentacoes realizadas
     * @return Lista de todas as movimentacoes vinculadas ao correntista informado na chamada do metodo
     * @throws IllegalArgumentException Caso o Id informado não seja encontrado no banco de dados, informa que o correntista não foi localizado
     */
    public List<Movimentacao> findAllByIdCorrentista(Integer idCorrentista) throws IllegalArgumentException{

        var correntista = correntistaService.getCorrentistaByIdCorrentista(idCorrentista);
        if(correntista.isPresent()) {
            return correntista.get().getMovimentacoes();
        } else {
            throw new IllegalArgumentException("Correntista " +idCorrentista+ " não encontrado!");
        }
    }

    /**
     * @return Lista contendo as movimentacoes, numero da conta e nome do correntista que as realizou
     */
    public List<TabelaMovimentacaoCompletaDTO> findAllDTO() {

        var movimentacoes = movimentacaoRepository.findAll();
        return movimentacoes.stream().map(movimentacao -> new TabelaMovimentacaoCompletaDTO().movimentacaoParaDTO(movimentacao)).
                collect(Collectors.toList());
    }
}
