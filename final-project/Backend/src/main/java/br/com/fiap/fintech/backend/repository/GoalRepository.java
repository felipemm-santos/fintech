package br.com.fiap.fintech.backend.repository;

import br.com.fiap.fintech.backend.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {

}
