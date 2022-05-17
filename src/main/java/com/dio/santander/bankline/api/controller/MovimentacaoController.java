package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovaMovimentacaoDTO;
import com.dio.santander.bankline.api.dto.TabelaMovimentacaoCompletaDTO;
import com.dio.santander.bankline.api.service.MovimentacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    public MovimentacaoController( MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody NovaMovimentacaoDTO novaMovimentacao) {
        try {
            movimentacaoService.save(novaMovimentacao);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<List<TabelaMovimentacaoCompletaDTO>> listaCompleta() {
        return ResponseEntity.ok().body(movimentacaoService.findAllDTO());
    }

}
