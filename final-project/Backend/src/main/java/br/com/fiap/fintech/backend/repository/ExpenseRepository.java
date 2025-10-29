package br.com.fiap.fintech.backend.repository;

import br.com.fiap.fintech.backend.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
