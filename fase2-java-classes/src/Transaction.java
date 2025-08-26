import java.time.LocalDate;

public abstract class Transaction extends Record{
    private String category;

    private boolean recurring;
    private int recurrenceInterval;
    private String recurrenceUnit;

    public Transaction(String name, String description, double amount, LocalDate operationDate, String category) {
        super(name, description, amount, operationDate);
        this.category = category;
        this.recurring = false;
        this.recurrenceInterval = 0;
    }

    public Transaction(String name, String description, double amount, LocalDate operationDate, String category, boolean recurring, int recurrenceInterval, String recurrenceUnit) {
        super(name, description, amount, operationDate);
        this.category = category;
        this.recurring = recurring;
        this.recurrenceInterval = recurrenceInterval;
        this.recurrenceUnit = recurrenceUnit;
    }

    public Transaction(String name, double amount, LocalDate operationDate, String category) {
        super(name, amount, operationDate);
        this.category = category;
        this.recurring = false;
        this.recurrenceInterval = 0;
    }

    public Transaction(String name, double amount, LocalDate operationDate,String category, boolean recurring, int recurrenceInterval, String recurrenceUnit) {
        super(name, amount, operationDate);
        this.category = category;
        this.recurring = recurring;
        this.recurrenceInterval = recurrenceInterval;
        this.recurrenceUnit = recurrenceUnit;
    }

    // Métodos da classe

    public LocalDate calculateNextDate(){
        /* Cálcula a data em que a mesma transação será feita novamente*/

        // Lógica para calcular data

        System.out.println("Calculando data da próxima transação de nome " + this.name);
        return null;
    }

    public abstract String getType();

    // Getters

    public String getCategory() {
        return category;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public int getRecurrenceInterval() {
        return recurrenceInterval;
    }

    public String getRecurrenceUnit() {
        return recurrenceUnit;
    }

    // Setters

    public Transaction setCategory(String category) {
        this.category = category;
        return this;
    }

    public Transaction setRecurring(boolean recurring) {
        this.recurring = recurring;
        return this;
    }

    public Transaction setRecurrenceInterval(int recurrenceInterval) {
        this.recurrenceInterval = recurrenceInterval;
        return this;
    }

    public Transaction setRecurrenceUnit(String recurrenceUnit) {
        this.recurrenceUnit = recurrenceUnit;
        return this;
    }
}
