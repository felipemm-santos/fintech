package br.com.fiap.fintech.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_FTC_FINANCIAL_GOAL")
public class Goal {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_FINANCIAL_GOAL"
    )
    @SequenceGenerator(
            name = "SEQ_FINANCIAL_GOAL",
            sequenceName = "SEQ_FINANCIAL_GOAL",
            allocationSize = 1
    )
    @Column(name = "ID_GOAL")
    private Long id;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "NM_GOAL")
    private String name;

    @Column(name = "VL_TARGET_AMOUNT")
    private Double targetAmount;

    @Column(name = "VL_CURRENT_AMOUNT")
    private Double currentAmount;

    @Column(name = "DT_TARGET_DATE")
    private LocalDate targetDate;

    @Column(name = "ST_STATUS")
    private String status;

    @Column(name = "DS_GOAL")
    private String description;

    @Column(name = "DT_COMPLETION_DATE")
    private LocalDate completionDate;

    @Column(name = "DT_CREATED_AT")
    private LocalDate createdAt;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Goal setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Goal setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Goal setName(String name) {
        this.name = name;
        return this;
    }

    public Double getTargetAmount() {
        return targetAmount;
    }

    public Goal setTargetAmount(Double targetAmount) {
        this.targetAmount = targetAmount;
        return this;
    }

    public Double getCurrentAmount() {
        return currentAmount;
    }

    public Goal setCurrentAmount(Double currentAmount) {
        this.currentAmount = currentAmount;
        return this;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public Goal setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Goal setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Goal setDescription(String description) {
        this.description = description;
        return this;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public Goal setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Goal setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}
