package br.com.fiap.fintech.backend.repository;

import br.com.fiap.fintech.backend.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomeRepository extends JpaRepository<Income, Long> {

}
