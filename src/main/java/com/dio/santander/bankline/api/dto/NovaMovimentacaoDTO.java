package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.model.MovimentacaoTipo;

public class NovaMovimentacaoDTO {

    private String descricao;
    private Double valorMovimentacao;
    private MovimentacaoTipo tipoMovimentacao;
    private Integer idCorrentista;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorMovimentacao() {
        return valorMovimentacao;
    }

    public void setValorMovimentacao(Double valor) {
        this.valorMovimentacao = valor;
    }

    public MovimentacaoTipo getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(MovimentacaoTipo tipo) {
        this.tipoMovimentacao = tipo;
    }

    public Integer getIdCorrentista() {
        return idCorrentista;
    }

    public void setIdCorrentista(Integer idCorrentista) {
        this.idCorrentista = idCorrentista;
    }

}
