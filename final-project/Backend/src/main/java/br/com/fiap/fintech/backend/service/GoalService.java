package br.com.fiap.fintech.backend.service;

import br.com.fiap.fintech.backend.model.Goal;
import br.com.fiap.fintech.backend.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    // save
    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    // findById
    public Goal findById(Long id) throws RuntimeException {
        Optional<Goal> goal = goalRepository.findById(id);
        if(!goal.isPresent()) {
            throw new RuntimeException("Goal not found");
        }
        return goal.get();
    }

    // listAll
    public List<Goal> listAll(){
        return goalRepository.findAll();
    }

    // update
    public Goal update(Long id, Goal goal) throws RuntimeException {
        Optional<Goal> oldGoal = goalRepository.findById(id);
        if(!oldGoal.isPresent()) {
            throw new RuntimeException("Goal not found");
        }
        return goalRepository.save(goal);
    }

    // delete
    public void delete(Long id) throws RuntimeException {
        Optional<Goal> goal  = goalRepository.findById(id);
        if(!goal.isPresent()) {
            throw new RuntimeException("Goal not found");
        }
        goalRepository.delete(goal.get());
    }
}
