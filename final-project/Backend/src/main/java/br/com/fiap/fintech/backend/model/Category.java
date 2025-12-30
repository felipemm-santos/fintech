package br.com.fiap.fintech.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_FTC_USER_CATEGORY")
public class Category {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USER_CATEGORY"
    )
    @SequenceGenerator(
            name = "SEQ_USER_CATEGORY",
            sequenceName = "SEQ_USER_CATEGORY",
            allocationSize = 1
    )
    @Column(name = "ID_CATEGORY")
    private Long id;

    @Column(name = "NM_CATEGORY")
    private String name;

    @Column(name = "DS_CATEGORYTYPE")
    private String type;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Category setType(String type) {
        this.type = type;
        return this;
    }

}