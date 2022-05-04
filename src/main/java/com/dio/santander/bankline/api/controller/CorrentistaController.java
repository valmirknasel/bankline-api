package com.dio.santander.bankline.api.controller;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import com.dio.santander.bankline.api.service.CorrentistaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {

    private final CorrentistaRepository correntistaRepository;
    private final CorrentistaService correntistaService;

    public CorrentistaController(CorrentistaRepository correntistaRepository, CorrentistaService correntistaService) {
        this.correntistaRepository = correntistaRepository;
        this.correntistaService = correntistaService;
    }

    @GetMapping
    public List<Correntista> findAll() {
        return correntistaRepository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista novoCorrentista) {
        correntistaService.save(novoCorrentista);
    }
}
