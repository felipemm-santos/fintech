import java.time.LocalDate;

public abstract class Record {
    protected String description;
    protected double amount;
    protected LocalDate operationDate;

    public Record(String description, double amount,  LocalDate operationDate) {
        this.description = description;
        this.amount = amount;
        this.operationDate = operationDate;
    }

    //Métodos da classe
    public abstract Record updateRecord();

    // Getters
    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    // Setters
    public Record setDescription(String description) {
        this.description = description;
        return this;
    }

    public Record setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public Record setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
        return this;
    }
}
