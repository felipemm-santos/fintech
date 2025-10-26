package br.com.fiap.fintech.model.category;

import br.com.fiap.fintech.model.User;

public class Category {
    private Integer id;
    private Integer userId;
    private String name;
    private CategoryType type; // TRANSACTION, INVESTMENT, GOAL

    public Category( Integer userId,String name,
                    CategoryType type) {
        this.userId = userId;
        this.name = name;
        this.type = type;
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public CategoryType getType() {
        return type;
    }

    // Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }
}
