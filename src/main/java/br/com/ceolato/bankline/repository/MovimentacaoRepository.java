package br.com.ceolato.bankline.repository;

import br.com.ceolato.bankline.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
}
