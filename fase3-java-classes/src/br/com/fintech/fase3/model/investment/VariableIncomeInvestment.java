package br.com.fintech.fase3.model.investment;

import br.com.fintech.fase3.model.Record;

import java.time.LocalDate;
import java.util.ArrayList;

public class VariableIncomeInvestment extends Investment {
    private String ticker;

    // Construtores

    public VariableIncomeInvestment() {
        super();
    }

    public VariableIncomeInvestment(String name, String assetType, double tax, String ticker) {
        super(name,assetType,tax);
        this.ticker = ticker;
    }

    // Métodos da classe

    public double getCurrentQuantity(){
        /* Retorna a quantidade cotas existentes do ativo */

        // Lógica para retornar a quantidade de cotas
        System.out.println("Verificando quantidade de cotas do ativo " + this.name);
        return 0;
    }

    public double calculateAverageCost(){
        /* Calcula o preço médio de compra do ativo */

        // Lógica para calcular preço médio
        System.out.println("Calculando preço médio de compra do ativo " + this.name);
        return 0;
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



    // Setters

    public VariableIncomeInvestment setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

}
