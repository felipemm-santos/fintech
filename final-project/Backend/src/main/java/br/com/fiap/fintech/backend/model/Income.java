package br.com.fiap.fintech.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "T_FTC_INCOME")
public class Income {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_INCOME"
    )
    @SequenceGenerator(
            name = "SEQ_INCOME",
            sequenceName = "SEQ_INCOME",
            allocationSize = 1
    )
    @Column(name = "ID_INCOME")
    private Long id;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "ID_CATEGORY")
    private Long categoryId;

    @Column(name = "DS_INCOME")
    private String description;

    @Column(name = "VL_INCOME")
    private Double value;

    @Column(name = "ST_STATUS")
    private String status;

    @Column(name = "DT_DUEDATE")
    private LocalDate dueDate;

    @Column(name = "DT_INCOME")
    private LocalDate paymentDate;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Income setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Income setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public Income setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Income setDescription(String description) {
        this.description = description;
        return this;
    }

    public Double getValue() {
        return value;
    }

    public Income setValue(Double value) {
        this.value = value;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Income setStatus(String status) {
        this.status = status;
        return this;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Income setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Income setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
        return this;
    }
}
