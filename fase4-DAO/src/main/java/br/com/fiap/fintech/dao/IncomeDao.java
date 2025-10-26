package br.com.fiap.fintech.dao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.transaction.Income;
import br.com.fiap.fintech.factory.ConnectionFactory;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class IncomeDao {
    private Connection connection;

    public IncomeDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {connection.close();}

    public void insert(Income income) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO T_FTC_INCOME (" +
                        "id_user, id_category, ds_income, vl_income, dt_income" +
                        ") VALUES (?,?,?,?,?)"
        );
        statement.setInt(1, income.getUserId());
        statement.setInt(2,income.getCategoryId());
        statement.setString(3, income.getDescription());
        statement.setDouble(4, income.getAmount());
        statement.setDate(5, Date.valueOf(income.getTransactionDate()));
        statement.executeUpdate();
    }

    public List<Income> getAll() throws SQLException,
            EntityNotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM T_FTC_INCOME"
        );
        ResultSet result = statement.executeQuery();
        if (!result.next()) throw new EntityNotFoundException();
        List<Income> incomes = new ArrayList<>();
        while (result.next()) {
            Integer id =  result.getInt("id_income");
            Integer userId = result.getInt("id_user");
            Integer categoryId = result.getInt("id_category");
            String description =  result.getString("ds_income");
            Double amount = result.getDouble("vl_income");
            String status = result.getString("st_income");
            LocalDate dueDate = result.getDate("dt_dueDate").toLocalDate();
            LocalDate incomeDate = result.getDate("dt_income").toLocalDate();

            // Add dueDate and transactionDate to database
            Income income = new Income(userId, description, amount,
                    status, dueDate,incomeDate);
            income.setId(id);
            incomes.add(income);
        };
        return incomes;
    };
};
