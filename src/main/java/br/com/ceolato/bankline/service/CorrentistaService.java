package br.com.ceolato.bankline.service;

import br.com.ceolato.bankline.dto.NovoCorrentista;
import br.com.ceolato.bankline.model.Conta;
import br.com.ceolato.bankline.model.Correntista;
import br.com.ceolato.bankline.repository.CorrentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    @Autowired
    private CorrentistaRepository repository;

    public void save(NovoCorrentista novoCorrentista){
        Correntista correntista = new Correntista();
        correntista.setNome(novoCorrentista.getNome());
        correntista.setCpf(novoCorrentista.getCpf());

        Conta conta = new Conta();
        conta.setSaldo(0.0);
        conta.setNumero(new Date().getTime());

        correntista.setConta(conta);

        repository.save(correntista);
    }

}
