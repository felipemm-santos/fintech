package br.com.fintech.fase3.model;

public abstract class Record {
    protected String name;
    protected String description;
    protected String category;

    // Construtores
    public Record() {}

    public Record(String name) {
        this.name = name;
        this.description = "";
    }

    public Record(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Métodos da classe
    public abstract Record updateRecord();

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

    // Setters
    public Record setName(String name) {
        this.name = name;
        return this;
    }

    public Record setDescription (String description) {
        this.description = description;
        return this;
    }

    public Record setCategory(String category) {
        this.category = category;
        return this;
    }

}
