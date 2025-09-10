package br.com.fintech.fase3.view;

import br.com.fintech.fase3.model.User;
import br.com.fintech.fase3.model.transaction.*;

public class Teste {
    public static void main(String[] args) {
        User user = new User("Felipe","exemplo@email.com","senha123");

        Income income1 = new Income("Salário",2000.00, TransactionType.INCOME, TransactionStatus.COMPLETED);
        user.addToRecord(income1);

        Expense expense1 = new Expense("Compra mercado", 500.00, TransactionType.EXPENSE, TransactionStatus.COMPLETED);
        user.addToRecord(expense1);

        double userBalance = user.getCurrentBalance();

        System.out.println("Balanço atual do usuário " + user.getName() + ": R$ " + userBalance);

    }
}
