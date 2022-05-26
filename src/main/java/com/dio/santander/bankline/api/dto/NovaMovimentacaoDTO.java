package com.dio.santander.bankline.api.dto;

import com.dio.santander.bankline.api.model.MovimentacaoTipo;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NovaMovimentacaoDTO {

    @JsonProperty("_descricao")
    private String descricao;
    @JsonProperty("_valorMovimentacao")
    private Double valorMovimentacao;
    @JsonProperty("_tipoMovimentacao")
    private MovimentacaoTipo tipoMovimentacao;
    @JsonProperty("_idCorrentista")
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
