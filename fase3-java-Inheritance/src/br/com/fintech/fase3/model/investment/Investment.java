package br.com.fintech.fase3.model.investment;

import br.com.fintech.fase3.model.record.RecordType;
import br.com.fintech.fase3.model.record.UserRecord;

import java.util.ArrayList;

public abstract class Investment extends UserRecord {
    protected String assetType; // tipo de ativo: ações, fundo imobiliário, tesouro direto, etc...
    protected Double tax; // percentual do imposto (ex: 0.15 = 15%), pode ser null se isento

    protected ArrayList<InvestmentOperation> operations;

    // Construtores
    protected Investment() {
        super(RecordType.INVESTMENT);
    }

    protected Investment(String name, String assetType, double tax) {
        super(name, RecordType.INVESTMENT);
        this.assetType = assetType;
        this.tax = tax;
    }

    protected Investment(String name, String description, String assetType, double tax) {
        super(name,description, RecordType.INVESTMENT);
        this.assetType = assetType;
        this.tax = tax;
    }

    // Métodos implementados
    public ArrayList<InvestmentOperation> addOperation(InvestmentOperation operation) {
        this.operations.add(operation);
        return operations;
    }

    public ArrayList<InvestmentOperation> removeOperation(InvestmentOperation operation) {
        this.operations.remove(operation);
        return operations;
    }

    public double getInvestedAmount() {
        /* Retorna o valor investido/aportado no ativo */

        // Lógica para retornar o valor investido
        System.out.println("Verificando o valor total investido em" + this.name);
        return 0;
    }

    public double getCurrentValue(){
        /* Retorna o valor total atual possuído em um ativo considerando valorização, rendimento, etc ..*/

        // Lógica para obter o valor de mercado
        System.out.println("Verificando valor atual do ativo " + this.name);
        return 0;
    }

    // Métodos abstratos
    public abstract double getInvestmentReturn();

    // Getters
    public String getAssetType() {
        return assetType;
    }

    public Double getTax() {
        return tax;
    }

    public ArrayList<InvestmentOperation> getOperations() {
        return operations;
    }

    // Setters
    public Investment setAssetType(String assetType) {
        this.assetType = assetType;
        return this;
    }

    public Investment setTax(Double tax) {
        this.tax = tax;
        return this;
    }

    public Investment setOperations(ArrayList<InvestmentOperation> operations) {
        this.operations = operations;
        return this;
    }
}
