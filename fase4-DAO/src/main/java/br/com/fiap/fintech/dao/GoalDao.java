package br.com.fiap.fintech.dao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.goal.Goal;
import br.com.fiap.fintech.factory.ConnectionFactory;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class GoalDao {
    private Connection connection;

    public GoalDao() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    public void closeConnection() throws SQLException {connection.close();}

    public void insert(Goal goal) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO T_FTC_FINANCIAL_GOAL (" +
                        "id_user, nm_goal, vl_targetAmount, vl_currentAmount, dt_targetDate," +
                        "st_status,ds_goal,dt_completionDate,dt_createdAt" +
                        ") VALUES (?,?,?,?,?,?,?,?,?)"
        );
        statement.setInt(1, goal.getUserId());
        statement.setString(2,goal.getName());
        statement.setDouble(3, goal.getTargetAmount());
        statement.setDouble(4, goal.getCurrentAmount());
        statement.setDate(5, Date.valueOf(goal.getTargetDate()));
        statement.setInt(6,goal.getStatus());
        statement.setString(7,goal.getDescription());
        statement.setDate(8,Date.valueOf(goal.getCompletionDate()));
        statement.setDate(9,Date.valueOf(LocalDate.now()));

        statement.executeUpdate();
    }

    public List<Goal> getAll() throws SQLException,
            EntityNotFoundException {
        PreparedStatement statement = connection.prepareStatement(
                "SELECT * FROM T_FTC_GOAL"
        );
        ResultSet result = statement.executeQuery();
        if (!result.next()) throw new EntityNotFoundException();
        List<Goal> goals = new ArrayList<>();
        while (result.next()) {
            Integer id =  result.getInt("id_goal");
            Integer userId = result.getInt("id_user");
            String name = result.getString("nm_goal");
            Double targetAmount =  result.getDouble("vl_targetAmount");
            Double currentAmount = result.getDouble("vl_currentAmount");
            LocalDate targetDate = result.getDate("dt_targetDate").toLocalDate();
            Integer status = result.getInt("st_status");
            String description = result.getString("ds_goal");
            LocalDate completionDate = result.getDate("dt_completionDate").toLocalDate();
            LocalDate createdAt = result.getDate("dt_createdAt").toLocalDate();

            // Add dueDate and transactionDate to database
            Goal goal = new Goal(userId,name,targetAmount,targetDate,currentAmount);
            goal.setId(id);
            goal.setStatus(status);
            goal.setDescription(description);
            goal.setCompletionDate(completionDate);
            goal.setCreatedAt(createdAt);
            goals.add(goal);
        };
        return goals;
    };
};
