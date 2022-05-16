package com.dio.santander.bankline.api.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_movimentacao")
public class Movimentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    private String descricao;
    private Double valor;

    @Column(name = "id_correntista")
    private Integer idCorrentista;

    //@Enumerated grava o valor literal do enum no banco
    @Enumerated(EnumType.STRING)
    private MovimentacaoTipo tipo;

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

    public Integer getIdCorrentista() {
        return idCorrentista;
    }

    public void setIdCorrentista(Integer idConta) {
        this.idCorrentista = idConta;
    }

    public MovimentacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MovimentacaoTipo tipo) {
        this.tipo = tipo;
    }
}
