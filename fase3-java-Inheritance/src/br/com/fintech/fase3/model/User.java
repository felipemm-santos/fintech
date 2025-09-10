package br.com.fintech.fase3.model;

import br.com.fintech.fase3.model.investment.Investment;
import br.com.fintech.fase3.model.record.UserRecord;
import br.com.fintech.fase3.model.transaction.Transaction;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    // Atributos

    private String name;
    private String email;
    private String password;

    private LocalDate birthday;
    private String genre;
    private String imgUrl;

    private ArrayList<Transaction> transactions =  new ArrayList<>();
    private ArrayList<Investment> investments  =  new ArrayList<>();
    private ArrayList<Goal> goals =  new ArrayList<>();

    // Construtores
    public User(){}

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Métodos da Classe

    public ArrayList<? extends UserRecord> addToRecord(UserRecord record) {
        /*Adiciona registro a lista de registros*/

        System.out.println("Adicionando registro: "  + record.getName());

        switch (record.getType()) {
            case "TRANSACTION":
                this.transactions.add((Transaction) record);
                return this.transactions;
            case "INVESTMENT":
                this.investments.add((Investment) record);
                return this.investments;
            case "GOAL":
                this.goals.add((Goal) record);
                return this.goals;
            default:
                return null;
        }
    }

    public ArrayList<? extends UserRecord> deleteFromRecord(UserRecord record) {
        /* Apaga registro da lista de registros */

        // Lógica para deletar registro
        System.out.println("Deletando registro"  + record.getName());

        switch (record.getType()) {
            case "TRANSACTION":
                this.transactions.remove((Transaction) record);
                return this.transactions;
            case "INVESTMENT":
                this.investments.remove((Investment) record);
                return this.investments;
            case "GOAL":
                this.goals.remove((Goal) record);
                return this.goals;
            default:
                return null;
        }
    }

    public String changePassword(String oldPassword, String newPassword) {
        /* Modifica senha do usuário */

        this.password = newPassword;
        System.out.println("Trocando senha do usuário:"
                + "\n Senha antiga:"  + oldPassword
                + "\n Nova senha " + newPassword
        );
        return this.password;
    }

    public String changeEmail(String email, String newEmail) {
        /* Troca e-mail do usuário*/

        this.email = newEmail;
        System.out.println("Trocando e-mail:"
                + "\n E-mail antigo:" + email
                + "\n Novo E-mail " + newEmail
        );
        return email;
    }

    public User updateProfile() {
        /* Atualizar cadastro do usuário*/

        // Lógica para atualizar cadastro
        System.out.println("Atualizando perfil do usuário: " + this.name);
        return this;
    }

    public User deleteAccount() {
        /* Deleta conta do usuário */

        // Lógica para deletar a conta do usuário
        System.out.println("Deletando conta do usuário: " + this.name);
        return this;
    }

    public double getCurrentBalance() {
        /* Soma dos valores de todas as transações */
        double total = 0;
        for (Transaction transaction : this.transactions) {
            if (transaction.getTransactionType().equals("INCOME")) {
                total = total + transaction.getAmount();
            }else if (transaction.getTransactionType().equals("EXPENSE")) {
                total = total - transaction.getAmount();
            }
        }
        return total;
    }

    public double getTotalInvestmentsValue() {
        double total = 0;
        for (Investment investment : this.investments) {
            total += investment.getCurrentValue();
        }
        return total;
    }

    // Getters

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGenre() {
        return genre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public ArrayList<Investment> getInvestments() {
        return investments;
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }
    // Setters

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public User setGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public User setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public User setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    public User setInvestments(ArrayList<Investment> investments) {
        this.investments = investments;
        return this;
    }

    public User setGoals(ArrayList<Goal> goals) {
        this.goals = goals;
        return this;
    }
}
