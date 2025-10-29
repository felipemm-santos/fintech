package br.com.fiap.fintech.backend.controller;

import br.com.fiap.fintech.backend.model.Expense;
import br.com.fiap.fintech.backend.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    // Create new expense
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Expense create(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }

    // Get all expenses
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Expense> listAll() {
        return  expenseService.listAll();
    }

    // Get expense by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Expense findById(@PathVariable Long id) {
        return expenseService.findById(id);
    }

    // Update expense
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Expense update(@PathVariable Long id, @RequestBody Expense expense) {
        return expenseService.update(id, expense);
    }

    // Delete expense
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        expenseService.delete(id);
    }

}
