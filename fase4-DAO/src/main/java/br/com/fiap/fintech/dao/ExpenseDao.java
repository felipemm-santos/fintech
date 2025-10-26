package br.com.fiap.fintech.dao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.transaction.Expense;
import br.com.fiap.fintech.factory.ConnectionFactory;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ExpenseDao {
    private Connection connection;

    public ExpenseDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {connection.close();}

    public void insert(Expense expense) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO T_FTC_EXPENSE (" +
                        "id_user, id_category, ds_expense, vl_expense, dt_expense" +
                        ") VALUES (?,?,?,?,?)"
        );
        statement.setInt(1, expense.getUserId());
        statement.setInt(2,expense.getCategoryId());
        statement.setString(3, expense.getDescription());
        statement.setDouble(4, expense.getAmount());
        statement.setDate(5, Date.valueOf(expense.getTransactionDate()));
        statement.executeUpdate();
    }

    public List<Expense> getAll() throws SQLException,
            EntityNotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM T_FTC_EXPENSE"
        );
        ResultSet result = statement.executeQuery();
        if (!result.next()) throw new EntityNotFoundException();
        List<Expense> expenses = new ArrayList<>();
        while (result.next()) {
            Integer id =  result.getInt("id_expense");
            Integer userId = result.getInt("id_user");
            Integer categoryId = result.getInt("id_category");
            String description =  result.getString("ds_expense");
            Double amount = result.getDouble("vl_expense");
            String status = result.getString("st_expense");
            LocalDate dueDate = result.getDate("dt_dueDate").toLocalDate();
            LocalDate expenseDate = result.getDate("dt_expense").toLocalDate();

            // Add dueDate and transactionDate to database
            Expense expense = new Expense(userId, description, amount,
                    status, dueDate,expenseDate);
            expense.setId(id);
            expenses.add(expense);
        };
        return expenses;
    };
};
