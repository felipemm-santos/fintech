package br.com.fiap.fintech.view;

import br.com.fiap.fintech.dao.GoalDao;
import br.com.fiap.fintech.exception.EntityNotFoundException;
import br.com.fiap.fintech.model.goal.Goal;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class GoalView {
    public static void main(String[] args) {
        try {
            GoalDao dao = new GoalDao();
            dao.insert(new Goal(1,"Reserva de emergência", 12000, LocalDate.of(2026,2,10),1500));
            dao.insert(new Goal(2,"Viagem Disney", 25000, LocalDate.of(2026,12,10),3000));
            dao.insert(new Goal(2,"Juntar R$ 100.000,00", 100000, LocalDate.of(2030,1,1),10000));
            dao.insert(new Goal(3,"Reserva de emergência", 30000, LocalDate.of(2026,2,15),10000));
            dao.insert(new Goal(4,"Reserva de emergência", 50000, LocalDate.of(2026,2,5),20000));


            List<Goal> goals = dao.getAll();
            for (Goal goal : goals) {
                System.out.println("Objetivo: " + goal.getId() + " " + goal.getName() +
                        "Usuário: " + goal.getUserId() +
                        "Valor desejado: " + goal.getTargetAmount() +
                        "Valor atual: " + goal.getCurrentAmount() +
                        "Data para finalizar objetivo: " + goal.getCompletionDate()
                );
            }

            dao.closeConnection();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }catch (EntityNotFoundException e) {
            System.err.println("Objetivo não encontrado");
        }

    }
}
