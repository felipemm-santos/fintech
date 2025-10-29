package br.com.fiap.fintech.backend.controller;

import br.com.fiap.fintech.backend.model.Income;
import br.com.fiap.fintech.backend.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
public class IncomeController {
    @Autowired
    private IncomeService incomeService;

    // Create new income
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Income create(@RequestBody Income income) {
        return incomeService.save(income);
    }

    // Get all incomes
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Income> listAll() {
        return  incomeService.listAll();
    }

    // Get income by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Income findById(@PathVariable Long id) {
        return incomeService.findById(id);
    }

    // Update income
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Income update(@PathVariable Long id, @RequestBody Income income) {
        return incomeService.update(id, income);
    }

    // Delete income
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        incomeService.delete(id);
    }

}
