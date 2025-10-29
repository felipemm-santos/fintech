package br.com.fiap.fintech.backend.service;

import br.com.fiap.fintech.backend.model.Expense;
import br.com.fiap.fintech.backend.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // save
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    // findById
    public Expense findById(Long id) throws RuntimeException {
        Optional<Expense> expense = expenseRepository.findById(id);
        if(!expense.isPresent()) {
            throw new RuntimeException("Expense not found");
        }
        return expense.get();
    }

    // listAll
    public List<Expense> listAll(){
        return expenseRepository.findAll();
    }

    // update
    public Expense update(Long id, Expense expense) throws RuntimeException {
        Optional<Expense> oldExpense = expenseRepository.findById(id);
        if(!oldExpense.isPresent()) {
            throw new RuntimeException("Expense not found");
        }
        return expenseRepository.save(expense);
    }

    // delete
    public void delete(Long id) throws RuntimeException {
        Optional<Expense> expense  = expenseRepository.findById(id);
        if(!expense.isPresent()) {
            throw new RuntimeException("Expense not found");
        }
        expenseRepository.delete(expense.get());
    }
}