package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.model.Movimentacao;
import com.dio.santander.bankline.api.model.MovimentacaoTipo;

import java.time.LocalDateTime;

public class TabelaMovimentacaoCompletaDTO {

    private Integer idMovimentacao;
    private LocalDateTime dataHora;
    private Long numeroContaCorrentista;
    private String nomeDoCorrentista;
    private String descricao;
    private MovimentacaoTipo tipoMovimentacao;
    private Double valor;

    public TabelaMovimentacaoCompletaDTO movimentacaoParaDTO(Movimentacao movimentacao) {
        TabelaMovimentacaoCompletaDTO tabelaCompleta = new TabelaMovimentacaoCompletaDTO();

        tabelaCompleta.setIdMovimentacao(movimentacao.getId());
        tabelaCompleta.setDataHora(movimentacao.getDataHora());
        tabelaCompleta.setDescricao(movimentacao.getDescricao());
        tabelaCompleta.setValor(movimentacao.getValor());
        tabelaCompleta.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
        tabelaCompleta.setNumeroContaCorrentista(movimentacao.getCorrentista().getConta().getNumero());
        tabelaCompleta.setNomeDoCorrentista(movimentacao.getCorrentista().getNome());
        return tabelaCompleta;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public MovimentacaoTipo getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(MovimentacaoTipo tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public String getNomeDoCorrentista() {
        return nomeDoCorrentista;
    }

    public void setNomeDoCorrentista(String nomeDoCorrentista) {
        this.nomeDoCorrentista = nomeDoCorrentista;
    }

    public Long getNumeroContaCorrentista() {
        return numeroContaCorrentista;
    }

    public void setNumeroContaCorrentista(Long numeroContaCorrentista) {
        this.numeroContaCorrentista = numeroContaCorrentista;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }
}
