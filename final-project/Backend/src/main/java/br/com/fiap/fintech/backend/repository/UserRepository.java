package br.com.fiap.fintech.backend.repository;

import br.com.fiap.fintech.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}
