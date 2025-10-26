package br.com.fiap.fintech.model.investment;

import br.com.fiap.fintech.model.record.UserRecord;

import java.time.LocalDate;

public class FixedIncomeInvestment extends Investment {
    private LocalDate maturityDate;
    private Integer liquidityInDays;

    private double annualRate;           // Taxa anual fixa
    private String index;                // Ex: CDI, SELIC, IPCA

    // Construtores

    public FixedIncomeInvestment() {}

    public FixedIncomeInvestment(String name, String assetType, double tax, LocalDate maturityDate, Integer liquidityInDays, double annualRate) {
        super(name,assetType,tax);
        this.maturityDate = maturityDate;
        this.liquidityInDays = liquidityInDays;
        this.annualRate = annualRate;
        this.index = null;
    }

    public FixedIncomeInvestment(String name, String assetType, double tax, LocalDate maturityDate, Integer liquidityInDays, String index) {
        super(name,assetType,tax);
        this.maturityDate = maturityDate;
        this.liquidityInDays = liquidityInDays;
        this.annualRate = 0;
        this.index = index;
    }

    // Implementação dos Métodos das classes super
    @Override
    public double getInvestmentReturn() {
        /* Calcula retorno do investimento */

        // Lógica para calcular retorno do investimento
        System.out.println("Calculando o retorno do investimento " + this.name);
        return 0;
    }

    @Override
    public UserRecord updateRecord() {
        /*Atualiza dados do registro */
        System.out.println("Atualizando o registro do investimento " + this.name);
        return this;
    }

    // Getters
    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public Integer getLiquidityInDays() {
        return liquidityInDays;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public String getIndex() {
        return index;
    }

    // Setters

    public FixedIncomeInvestment setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
        return this;
    }

    public FixedIncomeInvestment setLiquidityInDays(Integer liquidityInDays) {
        this.liquidityInDays = liquidityInDays;
        return this;
    }

    public FixedIncomeInvestment setAnnualRate(double annualRate) {
        this.annualRate = annualRate;
        return this;
    }

    public FixedIncomeInvestment setIndex(String index) {
        this.index = index;
        return this;
    }

}
