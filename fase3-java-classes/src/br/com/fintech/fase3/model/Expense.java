package br.com.fintech.fase3.model;

import java.time.LocalDate;

public class Expense extends Transaction{
    private LocalDate dueDate;

    public Expense(String name, String description, double amount, LocalDate operationDate, LocalDate dueDate, String category) {
        super(name, description, amount, operationDate, category);
        this.dueDate = dueDate;
    }

    public Expense(String name, String description, double amount, LocalDate operationDate, LocalDate dueDate,String category, boolean recurring, int recurrenceInterval, String recurrenceUnit) {
        super(name, description, amount, operationDate, category, recurring, recurrenceInterval, recurrenceUnit);
        this.dueDate = dueDate;
    }

    public Expense(String name, double amount, LocalDate operationDate, LocalDate dueDate,String category) {
        super(name, amount, operationDate, category);
        this.dueDate = dueDate;
    }

    public Expense(String name, double amount, LocalDate operationDate, LocalDate dueDate,String category, boolean recurring, int recurrenceInterval, String recurrenceUnit) {
        super(name, amount, operationDate, category, recurring, recurrenceInterval, recurrenceUnit);
        this.dueDate = dueDate;
    }

    public void dueDateAlert() {
        /* Avisa o usuário se a data de pagamento de uma despesa está próxima*/

        // Lógica para gerar o aviso
        System.out.println("Verificando se a data de pagamento está próxima");
    }

    // Implementação dos métodos da classe super
    @Override
    public Record updateRecord() {
        // Lógica para atualizar o registro
        System.out.println("Atualizando registro da despesa " +  this.name);
        return null;
    }

    @Override
    public String getType() {
        return "br.com.fintech.fase3.model.Expense";
    }

    // Getters
    public LocalDate getDueDate() {
        return dueDate;
    }

    // Setters
    public Expense setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
