package br.com.ceolato.bankline.controller;

import br.com.ceolato.bankline.dto.NovoCorrentista;
import br.com.ceolato.bankline.model.Correntista;
import br.com.ceolato.bankline.repository.CorrentistaRepository;
import br.com.ceolato.bankline.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("correntistas")
public class CorrentistaController {

    @Autowired
    private CorrentistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll(){
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista novoCorrentista){
        service.save(novoCorrentista);
    }

}
