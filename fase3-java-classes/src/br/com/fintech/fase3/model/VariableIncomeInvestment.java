package br.com.fintech.fase3.model;

import java.time.LocalDate;

public class VariableIncomeInvestment extends Investment {
    private String ticker;
    private double purchasePrice;
    private int shares;

    // Construtores
    public VariableIncomeInvestment(String ticker, double purchasePrice, int shares, LocalDate operationDate) {
        super(ticker, purchasePrice * shares,operationDate);
        this.ticker = ticker;
        this.purchasePrice = purchasePrice;
        this.shares = shares;
    }

    public VariableIncomeInvestment(String ticker, double purchasePrice, int shares, String description, LocalDate operationDate) {
        super(ticker, purchasePrice * shares,operationDate);
        this.ticker = ticker;
        this.purchasePrice = purchasePrice;
        this.shares = shares;
        this.description = description;
    }

    // Métodos da classe

    public double calculateAverageCost(){
        /* Calcula o preço médio de compra do ativo */

        // Lógica para calcular preço médio
        System.out.println("Calculando preço médio de compra do ativo " + this.name);
        return 0;
    }

    // Implementação dos Métodos das classes super
    @Override
    public double calculateReturn() {
        /* Calcula retorno do investimento */

        // Lógica para calcular retorno do investimento
        System.out.println("Calculando o retorno do investimento " + this.name);
        return 0;
    }

    @Override
    public Record updateRecord() {
        /*Atualiza dados do registro */

        // Lógica para atualizar o registro
        System.out.println("Atualizando o registro do investimento " + this.name);
        return this;
    }

    // Getters

    public String getTicker() {
        return ticker;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getShares() {
        return shares;
    }

    // Setters

    public VariableIncomeInvestment setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    public VariableIncomeInvestment setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public VariableIncomeInvestment setShares(int shares) {
        this.shares = shares;
        return this;
    }
}
