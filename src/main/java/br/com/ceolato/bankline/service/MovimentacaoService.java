package br.com.ceolato.bankline.service;

import br.com.ceolato.bankline.dto.NovaMovimentacao;
import br.com.ceolato.bankline.model.Correntista;
import br.com.ceolato.bankline.model.Movimentacao;
import br.com.ceolato.bankline.model.MovimentacaoTipo;
import br.com.ceolato.bankline.repository.CorrentistaRepository;
import br.com.ceolato.bankline.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {

    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrentistaRepository correntistaRepository;

    public void save(NovaMovimentacao novaMovimentacao){

        Double valor = novaMovimentacao.getTipo().equals(MovimentacaoTipo.RECEITA) ?
                novaMovimentacao.getValor() : novaMovimentacao.getValor() * -1;

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setValor(valor);
        movimentacao.setTipo(novaMovimentacao.getTipo());

        Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
        if(correntista != null){
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correntistaRepository.save(correntista);
        }


        repository.save(movimentacao);
    }
}
