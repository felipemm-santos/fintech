package br.com.fiap.fintech.backend.controller;

import br.com.fiap.fintech.backend.model.Investment;
import br.com.fiap.fintech.backend.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investment")
public class InvestmentController {
    @Autowired
    private InvestmentService investmentService;

    // Create new investment
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Investment create(@RequestBody Investment investment) {
        return investmentService.save(investment);
    }

    // Get all investments
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Investment> listAll() {
        return  investmentService.listAll();
    }

    // Get investment by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investment findById(@PathVariable Long id) {
        return investmentService.findById(id);
    }

    // Update investment
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Investment update(@PathVariable Long id, @RequestBody Investment investment) {
        return investmentService.update(id, investment);
    }

    // Delete investment
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        investmentService.delete(id);
    }

}
