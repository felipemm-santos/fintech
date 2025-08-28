package br.com.fintech.fase3.model;

import java.time.LocalDate;

public class Income extends Transaction{
    // Construtores
    public Income(String name, String description, double amount, LocalDate operationDate, String category) {
        super(name, description, amount, operationDate, category);
    }

    public Income(String name, String description, double amount, LocalDate operationDate, String category, boolean recurring, int recurrenceInterval, String recurrenceUnit) {
        super(name, description, amount, operationDate, category, recurring, recurrenceInterval, recurrenceUnit);
    }

    public Income(String name, double amount, LocalDate operationDate, String category) {
        super(name, amount, operationDate, category);
    }

    public Income(String name, double amount, LocalDate operationDate, String category, boolean recurring, int recurrenceInterval, String recurrenceUnit) {
        super(name, amount, operationDate, category, recurring, recurrenceInterval, recurrenceUnit);
    }

    // Implementação dos métodos da classe super
    @Override
    public Record updateRecord() {

        // Lógica para atualizar o registro
        System.out.println("Atualizando registro da receita " +  this.name);
        return null;
    }

    @Override
    public String getType() {
        return "br.com.fintech.fase3.model.Income";
    }
}
