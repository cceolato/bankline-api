package br.com.ceolato.bankline.repository;

import br.com.ceolato.bankline.model.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {
}
