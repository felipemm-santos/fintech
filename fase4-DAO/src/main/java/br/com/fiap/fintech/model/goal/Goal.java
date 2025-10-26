package br.com.fiap.fintech.model.goal;

import br.com.fiap.fintech.model.record.RecordType;
import br.com.fiap.fintech.model.record.UserRecord;

import java.time.LocalDate;

public class Goal extends UserRecord {
    private double targetAmount;
    private double currentAmount;
    private LocalDate targetDate;
    private LocalDate completionDate;
    private Integer status;

    // Construtores

    public Goal(Integer userId){
        super(userId, RecordType.GOAL);
    }

    public Goal(Integer userId, String name,
                double targetAmount,  LocalDate targetDate) {
        super(userId, name, RecordType.GOAL);
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
        currentAmount = 0.0;
    }

    public Goal(Integer userId,String name, double targetAmount,  LocalDate targetDate,  double currentAmount) {
        super(userId, name, RecordType.GOAL);
        this.targetAmount = targetAmount;
        this.targetDate = targetDate;
        this.currentAmount = currentAmount;
    }

    // Métodos da classe

    public double addAmount(double amount){
        /* Adiciona um determinado valor a meta */
        return currentAmount + amount;
    }

    public double removeAmount(double amount){
        /* Remove um determinado valor da meta */
        return currentAmount - amount;
    }

    public double getRemainingAmount(){
        /* Retorna o valor restante necessário para cumprir a meta */
        return targetAmount - currentAmount;
    }

    public double getProgressPercentage(){
        /* Retorna o progresso atingido em porcentagem */

        return currentAmount/targetAmount * 100;
    }

    public Integer daysRemaining(){
        /* Retorna a quantidade de dias faltando para a data definida para cumprir o objetivo*/

        // Lógica para retornar a quantidade de dias
        System.out.println("Calculando dias restantes para cumprir a meta");
        return 0;
    }

    // Getters

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public Integer getStatus() {
        return status;
    }

    // Setters

    public Goal setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
        return this;
    }

    public Goal setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
        return this;
    }

    public Goal setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
        return this;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
