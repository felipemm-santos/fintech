package br.com.fiap.fintech.backend.repository;

import br.com.fiap.fintech.backend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
