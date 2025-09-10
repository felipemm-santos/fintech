package br.com.fintech.fase3.model.investment;

import java.time.LocalDate;

public class InvestmentOperation {
    private LocalDate operationDate;
    private String operationType;
    private Investment investment;

    private double amount;       // valor total
    private Double quantity;     // qtd. de cotas (pode ser null em renda fixa)
    private Double unitPrice;    // preço unitário (pode ser null em renda fixa)

    private double taxPaid; // valor pago em impostos na operação. Exemplo: R$ 15,00

    public InvestmentOperation(){}

    public InvestmentOperation(LocalDate date, String operationType, Investment investment, double amount){
        this.operationDate = date;
        this.operationType = operationType;
        this.investment = investment;
        this.amount = amount;
        this.taxPaid = calculateTaxPaid(investment, operationType);
        investment.addOperation(this);
    }

    public InvestmentOperation(LocalDate date, String operationType, Investment investment, double quantity, double unitPrice){
        this.operationDate = date;
        this.operationType = operationType;
        this.investment = investment;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.amount = quantity * unitPrice;
        this.taxPaid = calculateTaxPaid(investment, operationType);
    }

    // Métodos da classe

    public double calculateTaxPaid(Investment investment, String operationType){
        /* Retorna o valor pago de impsotos em uma operação */
        if (investment.getTax() == null || investment.getTax() == 0.0) {
            return 0.0;
        }

        if (operationType.equals("WITHDRAW")) {
            return amount * investment.getTax();
        }
        else{
            return 0.0;
        }
    }

    // Métodos da classe super

    public InvestmentOperation updateOperation(){
        /* Atualiza o registo*/

        String typeText = "";
        // Lógica para atualizar o registro
        if (operationType.equals("WITHDRAW")) {
            typeText = "resgate do";
        } else if (operationType.equals("DEPOSIT")) {
            typeText = "aporte no";
        }

        System.out.println("Atualizando operação de " + typeText
                + "ativo " + this.investment.getName()
                + "que aconteceu no dia " + this.operationDate
        );
        return this;
    }

    // Getters

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public String getOperationType() {
        return operationType;
    }

    public Investment getInvestment() {
        return investment;
    }

    public double getAmount() {
        return amount;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    // Setters
    public InvestmentOperation setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
        return this;
    }

    public InvestmentOperation setOperationType(String operationType) {
        this.operationType = operationType;
        return this;
    }

    public InvestmentOperation setInvestment(Investment investment) {
        this.investment = investment;
        return this;
    }

    public InvestmentOperation setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public InvestmentOperation setQuantity(Double quantity) {
        this.quantity = quantity;
        return this;
    }

    public InvestmentOperation setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }
}
