package com.dio.santander.bankline.api.service;

import com.dio.santander.bankline.api.dto.NovoCorrentista;
import com.dio.santander.bankline.api.model.Conta;
import com.dio.santander.bankline.api.model.Correntista;
import com.dio.santander.bankline.api.repository.CorrentistaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CorrentistaService {

    private final CorrentistaRepository correntistaRepository;

    public CorrentistaService(CorrentistaRepository correntistaRepository) {
        this.correntistaRepository = correntistaRepository;
    }

    public void save(NovoCorrentista novoCorrentista) {
        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());

        Conta conta = new Conta();
        //inicia a conta com saldo zerado.
        conta.setSaldo(0.0);
        //regra arbitraria que define o numero da conta baseado na data atual
        conta.setNumero(new Date().getTime());
        correntista.setConta(conta);
        correntistaRepository.save(correntista);
    }

    public List<Correntista> findAll() {
        return correntistaRepository.findAll();
    }

    public Optional<Correntista> getCorrentistaByIdCorrentista(Integer idCorrentista) {
        return correntistaRepository.findById(idCorrentista);
    }

    public Correntista updateCorrentista(Correntista correntista) {
        var correntistaAtualizado = correntistaRepository.findById(correntista.getId());
        if(correntistaAtualizado.isPresent()) {
            return correntistaRepository.save(correntista);
        } else {
            throw new IllegalArgumentException("Correntista " + correntista.getNome() + "não encontrado!");
        }
    }
}
