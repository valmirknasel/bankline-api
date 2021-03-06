package com.dio.santander.bankline.api.repository;

import com.dio.santander.bankline.api.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

    @Query("SELECT m from Movimentacao m ORDER BY m.dataHora ASC")
    List<Movimentacao> findAll();
}
