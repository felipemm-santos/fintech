package br.com.fiap.fintech.backend.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_FTC_INVESTMENT")
public class Investment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_INVESTMENT"
    )
    @SequenceGenerator(
            name = "SEQ_INVESTMENT",
            sequenceName = "SEQ_INVESTMENT",
            allocationSize = 1
    )
    @Column(name = "ID_INVESTMENT")
    private Long id;

    @Column(name = "ID_USER")
    private Long userId;

    @Column(name = "NM_INVESTMENT")
    private String name;

    @Column(name = "NR_LIQUIDITY_IN_DAYS")
    private Integer liquidityDays;

    @Column(name = "DT_MATURITY")
    private LocalDate maturityDate;

    @Column(name = "DS_ASSET_TYPE")
    private String assetType;

    @Column(name = "DS_ASSET_CLASS")
    private String assetClass;

    @Column(name = "VL_ANNUAL_RATE")
    private Double annualRate;

    @Column(name = "DS_INDEX")
    private LocalDate index;

    @Column(name = "VL_TAX")
    private LocalDate tax;

    @Column(name = "DT_CREATED_AT")
    private LocalDate createdAt;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public Investment setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public Investment setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Investment setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Investment setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public LocalDate getLiquidityDays() {
        return liquidityDays;
    }

    public Investment setLiquidityDays(LocalDate liquidityDays) {
        this.liquidityDays = liquidityDays;
        return this;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public Investment setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
        return this;
    }

    public LocalDate getAssetType() {
        return assetType;
    }

    public Investment setAssetType(LocalDate assetType) {
        this.assetType = assetType;
        return this;
    }

    public LocalDate getAssetClass() {
        return assetClass;
    }

    public Investment setAssetClass(LocalDate assetClass) {
        this.assetClass = assetClass;
        return this;
    }

    public LocalDate getAnnualRate() {
        return annualRate;
    }

    public Investment setAnnualRate(LocalDate annualRate) {
        this.annualRate = annualRate;
        return this;
    }

    public LocalDate getIndex() {
        return index;
    }

    public Investment setIndex(LocalDate index) {
        this.index = index;
        return this;
    }

    public LocalDate getTax() {
        return tax;
    }

    public Investment setTax(LocalDate tax) {
        this.tax = tax;
        return this;
    }
}
