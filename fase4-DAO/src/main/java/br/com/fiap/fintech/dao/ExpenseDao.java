package br.com.fiap.fintech.dao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.transaction.Expense;
import br.com.fiap.fintech.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ExpenseDao {
    private Connection connection;

    public ExpenseDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    // Lembrar de remover instituição financeira do modelo
    public void insert(Expense expense) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO expenses (expenseId, userId," +
                        " " +
                        "categoryId," +
                        "description, " +
                        "amount, date) VALUES " +
                        "(seq_expense.nextval, ,?,?,?,?)"
        );
        statement.setLong(1, expense.getExpenseId());
        statement.setLong(2,expense.getUserId());
        statement.setLong(3,expense.getCategoryId());
        statement.setString(4, expense.getDescription());
        statement.setDouble(5, expense.getAmount());
        statement.setDate(6, Date.valueOf(expense.getTransactionDate()));
        statement.executeUpdate();
    }

    public List<Expense> getAll() throws SQLException,
            EntityNotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM expenses"
        );
        ResultSet result = statement.executeQuery();
        if (!result.next()) throw new EntityNotFoundException();
        List<Expense> expenses = new ArrayList<>();
        while (result.next()) {
            
        }
    }

}
