import java.time.LocalDate;

public class FixedIncomeInvestment extends Investment{
    private double annualRate;

    // Construtor
    public FixedIncomeInvestment(String name, double amount, LocalDate operationDate, double annualRate) {
        super(name,amount,operationDate);
        this.annualRate = annualRate;
    }

    public FixedIncomeInvestment(String name, String description, double amount,  LocalDate operationDate, double annualRate) {
        super(name,description,amount,operationDate);
        this.annualRate = annualRate;
    }

    // Implementação dos Métodos das classes super
    @Override
    public double calculateReturn() {
        /* Calcula retorno do investimento */

        double investmentReturn = this.amount * (this.annualRate / 100);
        System.out.println("Calculando o retorno do investimento " + this.name);
        return investmentReturn;
    }

    @Override
    public Record updateRecord() {
        /*Atualiza dados do registro */
        System.out.println("Atualizando o registro do investimento " + this.name);
        return this;
    }

    // Getters
    public double getAnnualRate() {
        return this.annualRate;
    }

    // Setters
    public void setAnnualRate(double annualRate) {
        this.annualRate = annualRate;
    }
}
