package br.com.fintech.fase3.model.transaction;

import br.com.fintech.fase3.model.Record;

import java.time.LocalDate;

public class Income extends Transaction {
    // Construtores

    public Income(String name, double amount, String type, String status) {
        super(name, amount, type, status);
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
        return "br.com.fintech.fase3.model.transaction.Income";
    }
}
