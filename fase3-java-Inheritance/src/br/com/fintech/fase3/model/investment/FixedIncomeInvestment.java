package br.com.fintech.fase3.model.investment;

import br.com.fintech.fase3.model.record.UserRecord;

import java.time.LocalDate;

public class FixedIncomeInvestment extends Investment {
    private LocalDate maturityDate;
    private int liquidityInDays;

    // Para prefixados
    private double annualRate;           // Taxa anual fixa (null se pós-fixado)

    // Para pós-fixados
    private String index;                  // Ex: CDI, SELIC, IPCA
    private double indexPercentage;        // Percentual aplicado sobre o índice

    // Construtores

    public FixedIncomeInvestment() {}

    public FixedIncomeInvestment(String name, String assetType, double tax, LocalDate maturityDate, int liquidityInDays, double annualRate) {
        super(name,assetType,tax);
        this.maturityDate = maturityDate;
        this.liquidityInDays = liquidityInDays;
        this.annualRate = annualRate;
        this.index = null;
        this.indexPercentage = 0;
    }

    public FixedIncomeInvestment(String name, String assetType, double tax, LocalDate maturityDate, int liquidityInDays, String index, double indexPercentage) {
        super(name,assetType,tax);
        this.maturityDate = maturityDate;
        this.liquidityInDays = liquidityInDays;
        this.annualRate = 0;
        this.index = index;
        this.indexPercentage = indexPercentage;
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

    public int getLiquidityInDays() {
        return liquidityInDays;
    }

    public double getAnnualRate() {
        return annualRate;
    }

    public String getIndex() {
        return index;
    }

    public double getIndexPercentage() {
        return indexPercentage;
    }

    // Setters

    public FixedIncomeInvestment setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
        return this;
    }

    public FixedIncomeInvestment setLiquidityInDays(int liquidityInDays) {
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

    public FixedIncomeInvestment setIndexPercentage(double indexPercentage) {
        this.indexPercentage = indexPercentage;
        return this;
    }
}
