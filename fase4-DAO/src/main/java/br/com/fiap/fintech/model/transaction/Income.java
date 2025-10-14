package br.com.fiap.fintech.model.transaction;

import br.com.fiap.fintech.model.record.UserRecord;

public class Income extends Transaction {
    // Construtores

    public Income(Long id, Long userId, String name,
                  double amount,
                  String transactionType, String status) {
        super(id, userId, name, amount, transactionType,
                status);
    }

    // Implementação dos métodos da classe super
    @Override
    public UserRecord updateRecord() {

        // Lógica para atualizar o registro
        System.out.println("Atualizando registro da receita " +  this.name);
        return this;
    }
}
