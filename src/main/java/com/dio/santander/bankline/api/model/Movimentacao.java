package com.dio.santander.bankline.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_hora")
    @NotNull
    private LocalDateTime dataHora;

    @NotNull
    private String descricao;
    private Double valor;

    //@Enumerated grava o valor literal do enum no banco
    @Enumerated(EnumType.STRING)
    @NotNull
    private MovimentacaoTipo tipoMovimentacao;

    @ManyToOne
    @JoinColumn(name = "id_correntista")
    @NotNull
    @JsonIgnore()
    private Correntista correntista;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public @NotNull Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    public MovimentacaoTipo getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(MovimentacaoTipo tipo) {
        this.tipoMovimentacao = tipo;
    }
}
