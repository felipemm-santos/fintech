package br.com.fiap.fintech.model.record;

import java.time.LocalDate;

public abstract class UserRecord {
    protected Integer id;
    protected Integer userId;
    protected Integer categoryId;
    protected String name;
    protected String description;
    protected String type;
    protected LocalDate createdAt;

    // Construtores
    protected UserRecord(Integer userId,String type) {
        this.userId = userId;
        this.type = type;
        this.createdAt = LocalDate.now();
    }

    protected UserRecord(Integer userId,String name,
                         String type) {

        this.userId = userId;
        this.name = name;
        this.description = "";
        this.type = type;
        this.createdAt = LocalDate.now();

    }

    protected UserRecord(Integer userId,String name,
                         String description,Integer categoryId, String type) {

        this.userId = userId;
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.type = type;
        this.createdAt = LocalDate.now();
    }

    // Getters

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    // Setters


    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(Integer userId) {
        this.userId = userId;
    }

    public void setCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

}
