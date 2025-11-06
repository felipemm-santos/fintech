package br.com.fiap.fintech.backend.service;

import br.com.fiap.fintech.backend.model.Investment;
import br.com.fiap.fintech.backend.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    // save
    public Investment save(Investment investment) {
        return investmentRepository.save(investment);
    }

    // findById
    public Investment findById(Long id) throws RuntimeException {
        Optional<Investment> investment = investmentRepository.findById(id);
        if(!investment.isPresent()) {
            throw new RuntimeException("Investment not found");
        }
        return investment.get();
    }

    // listAll
    public List<Investment> listAll(){
        return investmentRepository.findAll();
    }

    // update
    public Investment update(Long id, Investment investment) throws RuntimeException {
        Optional<Investment> oldInvestment = investmentRepository.findById(id);
        if(!oldInvestment.isPresent()) {
            throw new RuntimeException("Investment not found");
        }
        return investmentRepository.save(investment);
    }

    // delete
    public void delete(Long id) throws RuntimeException {
        Optional<Investment> investment  = investmentRepository.findById(id);
        if(!investment.isPresent()) {
            throw new RuntimeException("Investment not found");
        }
        investmentRepository.delete(investment.get());
    }
}
