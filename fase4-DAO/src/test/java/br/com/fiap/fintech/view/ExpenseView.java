package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.ExpenseDao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.transaction.Expense;
import br.com.fiap.fintech.model.transaction.TransactionStatus;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ExpenseView {
    public static void main(String[] args) {
        try {
            ExpenseDao dao = new ExpenseDao();
            dao.insert(new Expense(1, "Compra mercado", 800, TransactionStatus.COMPLETED, LocalDate.of(2025, 5, 12), LocalDate.of(2025, 5, 12)));

            dao.insert(new Expense(1, "uber", 17.5, TransactionStatus.COMPLETED, null, LocalDate.of(2025, 5, 12)));

            dao.insert(new Expense(2, "Conta de Luz", 225, TransactionStatus.PLANNED, LocalDate.of(2025, 6, 10), null));

            dao.insert(new Expense(2, "Conta de água", 225, TransactionStatus.PENDING, LocalDate.of(2025, 6, 5), null));

            dao.insert(new Expense(3, "Cinema", 25, TransactionStatus.COMPLETED, null, LocalDate.of(2025, 5, 2)));

            List<Expense> expenses = dao.getAll();
            for (Expense expense : expenses) {
                System.out.println(
                        expense.getId() + " " + expense.getUserId() + " " + expense.getName() +
                                "R$ " + expense.getAmount() + expense.getStatus() +
                                "Data de Vencimento: " + expense.getDueDate().toString() +
                                "Data de pagamento: " + expense.getTransactionDate().toString()
                );
            }
            
            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }catch (EntityNotFoundException e) {
            System.err.println("Despesa não encontrada");
        }

    }
}
