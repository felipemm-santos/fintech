package br.com.fiap.fintech.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_FTC_EXPENSE")
public class Expense {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_EXPENSE"
    )
    @SequenceGenerator(
            name = "SEQ_EXPENSE",
            sequenceName = "SEQ_EXPENSE",
            allocationSize = 1
    )
    @Column(name = "ID_EXPENSE")
    private Long id;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "ID_CATEGORY")
    private Long categoryId;

    @Column(name = "DS_EXPENSE")
    private String description;

    @Column(name = "VL_EXPENSE")
    private Double value;

    @Column(name = "ST_STATUS")
    private String status;

    @Column(name = "DT_DUEDATE")
    private LocalDate dueDate;

    @Column(name = "DT_EXPENSE")
    private LocalDate paymentDate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Expense setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Expense setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Expense setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Expense setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Expense setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Expense setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Expense setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Expense setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }
}
