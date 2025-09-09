package br.com.fintech.fase3.model.category;

public class Category {
    private String name;
    private CategoryType type; // TRANSACTION, INVESTMENT, GOAL

    public Category(String name, CategoryType type) {
        this.name = name;
        this.type = type;
    }

    // Getters
    public String getName() {
        return name;
    }

    public CategoryType getType() {
        return type;
    }

    // Setters
    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public Category setType(CategoryType type) {
        this.type = type;
        return this;
    }
}
