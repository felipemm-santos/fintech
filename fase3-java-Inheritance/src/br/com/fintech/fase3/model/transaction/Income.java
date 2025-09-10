package br.com.fintech.fase3.model.transaction;

import br.com.fintech.fase3.model.record.UserRecord;

public class Income extends Transaction {
    // Construtores

    public Income(String name, double amount, String transactionType, String status) {
        super(name, amount, transactionType, status);
    }

    // Implementação dos métodos da classe super
    @Override
    public UserRecord updateRecord() {

        // Lógica para atualizar o registro
        System.out.println("Atualizando registro da receita " +  this.name);
        return this;
    }
}
