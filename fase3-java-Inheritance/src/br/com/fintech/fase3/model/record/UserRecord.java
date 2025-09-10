package br.com.fintech.fase3.model.record;

public abstract class UserRecord {
    protected String name;
    protected String description;
    protected String category;
    protected String type;

    // Construtores
    protected UserRecord(String type) {
        this.type = type;
    }

    protected UserRecord(String name, String type) {
        this.name = name;
        this.description = "";
        this.type = type;
    }

    protected UserRecord(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    //Métodos da classe
    public abstract UserRecord updateRecord();

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    // Setters
    public UserRecord setName(String name) {
        this.name = name;
        return this;
    }

    public UserRecord setDescription (String description) {
        this.description = description;
        return this;
    }

    public UserRecord setCategory(String category) {
        this.category = category;
        return this;
    }

    public UserRecord setType(String type) {
        this.type = type;
        return this;
    }
}
