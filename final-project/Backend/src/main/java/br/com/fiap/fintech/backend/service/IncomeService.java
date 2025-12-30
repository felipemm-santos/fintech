package br.com.fiap.fintech.backend.service;

import br.com.fiap.fintech.backend.model.Income;
import br.com.fiap.fintech.backend.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    // save
    public Income save(Income income) {
        return incomeRepository.save(income);
    }

    // findById
    public Income findById(Long id) throws RuntimeException {
        Optional<Income> income = incomeRepository.findById(id);
        if(!income.isPresent()) {
            throw new RuntimeException("Income not found");
        }
        return income.get();
    }

    // listAll
    public List<Income> listAll(){
        return incomeRepository.findAll();
    }

    // update
    public Income update(Long id, Income income) throws RuntimeException {
        Optional<Income> oldIncome = incomeRepository.findById(id);
        if(!oldIncome.isPresent()) {
            throw new RuntimeException("Income not found");
        }
        return incomeRepository.save(income);
    }

    // delete
    public void delete(Long id) throws RuntimeException {
        Optional<Income> income  = incomeRepository.findById(id);
        if(!income.isPresent()) {
            throw new RuntimeException("Income not found");
        }
        incomeRepository.delete(income.get());
    }
}