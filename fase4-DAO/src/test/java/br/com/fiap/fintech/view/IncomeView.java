package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.IncomeDao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.transaction.Income;
import br.com.fiap.fintech.model.transaction.TransactionStatus;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class IncomeView {
    public static void main(String[] args) {
        try {
            IncomeDao dao = new IncomeDao();
            dao.insert(new Income(1, "Salário", 2000, TransactionStatus.COMPLETED, LocalDate.of(2025, 5, 7), LocalDate.of(2025, 5, 7)));

            dao.insert(new Income(1, "Salário", 2000, TransactionStatus.PLANNED, LocalDate.of(2025, 6, 7), null));

            dao.insert(new Income(1, "Freela Mercado", 1200, TransactionStatus.PLANNED, LocalDate.of(2025, 6, 20), null));

            dao.insert(new Income(2, "Salário", 3000, TransactionStatus.COMPLETED, LocalDate.of(2025, 6, 5), LocalDate.of(2025, 6, 5)));

            dao.insert(new Income(3, "Pag Emp Marcela 2/5", 157, TransactionStatus.PENDING, LocalDate.of(2025, 6, 6), null));

            List<Income> incomes = dao.getAll();
            for (Income income : incomes) {
                System.out.println(income.getId() + " " + income.getUserId() + " " + income.getName() + "R$ " + income.getAmount() + income.getStatus() + "Data de Vencimento: " + income.getDueDate().toString() + "Data de pagamento: " + income.getTransactionDate().toString());
            }

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.err.println("Receita não encontrada");
        }

    }
}