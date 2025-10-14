package br.com.fiap.fintech.model.category;

public class Category {
    private Long id;
    private Long userId;
    private String name;
    private CategoryType type; // TRANSACTION, INVESTMENT, GOAL

    public Category(Long id, Long userId,String name,
                    CategoryType type) {
        this.id = id;
        this.userId = userId;
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
