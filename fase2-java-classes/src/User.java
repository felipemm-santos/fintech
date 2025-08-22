import java.time.LocalDate;
import java.util.ArrayList;

public class User {
    // Atributos

    private String userName;
    private String email;
    private String password;

    private LocalDate birthday;
    private String genre;
    private String imgUrl;

    private ArrayList<Record> records;


    // Construtor padrão
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    // Métodos da Classe

    public ArrayList<Record> addRecord(Record record) {
        /*Adiciona registro a lista de registros*/

        // Lógica para adicionar registro
        System.out.println("Adicionando registro: "  + record.description);
        return this.records;
    }

    public ArrayList<Record> deleteRecord(Record record) {
        /* Apaga registro da lista de registros */

        // Lógica para deletar registro
        System.out.println("Deletando registro"  + record.description);
        return this.records;
    }

    public String changePassword(String oldPassword, String newPassword) {
        /* Modifica senha do usuário */

        // Lógica para mudar a senha do usuário.

        System.out.println("Trocando senha do usuário:"
                + "\n Senha antiga:"  + oldPassword
                + "\n Nova senha " + newPassword
        );
        return this.password;
    }

    public String changeEmail(String email, String newEmail) {
        /* Troca e-mail do usuário*/

        // Lógica para trocar e-mail
        System.out.println("Trocando e-mail:"
                + "\n E-mail antigo:" + email
                + "\n Novo E-mail " + newEmail
        );
        return this.email;
    }

    public User updateProfile() {
        /* Atualizar cadastro do usuário*/

        // Lógica para atualizar cadastro
        System.out.println("Atualizando perfil do usuário: " + this.userName);
        return this;
    }

    public User deleteAccount() {
        /* Deleta conta do usuário */

        // Lógica para deletar a conta do usuário
        System.out.println("Deletando conta do usuário: " + this.userName);
        return this;
    }

    // Getters

    public String getUserName() {
        return userName;
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

    public ArrayList<Record> getRecords() {
        return records;
    }

    // Setters

    public User setUserName(String userName) {
        this.userName = userName;
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

    public User setRecords(ArrayList<Record> records) {
        this.records = records;
        return this;
    }
}
