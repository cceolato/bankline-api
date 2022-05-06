package br.com.ceolato.bankline.controller;

import br.com.ceolato.bankline.dto.NovaMovimentacao;
import br.com.ceolato.bankline.dto.NovoCorrentista;
import br.com.ceolato.bankline.model.Correntista;
import br.com.ceolato.bankline.model.Movimentacao;
import br.com.ceolato.bankline.service.CorrentistaService;
import br.com.ceolato.bankline.repository.CorrentistaRepository;
import br.com.ceolato.bankline.repository.MovimentacaoRepository;
import br.com.ceolato.bankline.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movimentacoes")
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovaMovimentacao novaMovimentacao){
        service.save(novaMovimentacao);
    }

}
