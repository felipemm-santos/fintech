import java.util.ArrayList;

public class User {
    // Attributes

    private String name;
    private String email;
    private String password;

    private String birthday;
    private String genre;
    private String imgUrl;

    private ArrayList<Income> userIncomes;
    private ArrayList<Investment> userInvestments;
    private ArrayList<Expense> userExpenses;

    // Constructors
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Methods

    public ArrayList<Income> addIncome() {
        this.userIncomes.add(new Income());
        return this.userIncomes;
    }
    public ArrayList<Investment> addInvestment() {
        this.userInvestments.add(new Investment());
        return this.userInvestments;
    }
    public ArrayList<Expense> addExpense(){
        this.userExpenses.add(new Expense());
        return this.userExpenses;
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

    public String getBirthday() {
        return birthday;
    }

    public String getGenre() {
        return genre;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public ArrayList<Income> getUserIncomes() {
        return userIncomes;
    }

    public ArrayList<Investment> getUserInvestments() {
        return userInvestments;
    }

    public ArrayList<Expense> getUserExpenses() {
        return userExpenses;
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

    public User setBirthday(String birthday) {
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
}
