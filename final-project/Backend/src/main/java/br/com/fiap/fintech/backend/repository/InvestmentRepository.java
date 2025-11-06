package br.com.fiap.fintech.backend.repository;

import br.com.fiap.fintech.backend.model.Investment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {

}
