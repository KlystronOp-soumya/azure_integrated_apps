package com.demo.azure.df.flexinvest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyDetails {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("policyType")
    private String policyType;

    @JsonProperty("startDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonProperty("maturityDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate maturityDate;

    @JsonProperty("sumAssured")
    private BigDecimal sumAssured;

    @JsonProperty("premiumAmount")
    private BigDecimal premiumAmount;

    @JsonProperty("premiumFrequency")
    private String premiumFrequency;

    @JsonProperty("policyStatus")
    private String policyStatus;

    public String getProductName() {
        return productName;
    }

    public PolicyDetails setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public String getPolicyType() {
        return policyType;
    }

    public PolicyDetails setPolicyType(String policyType) {
        this.policyType = policyType;
        return this;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public PolicyDetails setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public PolicyDetails setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
        return this;
    }

    public BigDecimal getSumAssured() {
        return sumAssured;
    }

    public PolicyDetails setSumAssured(BigDecimal sumAssured) {
        this.sumAssured = sumAssured;
        return this;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public PolicyDetails setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
        return this;
    }

    public String getPremiumFrequency() {
        return premiumFrequency;
    }

    public PolicyDetails setPremiumFrequency(String premiumFrequency) {
        this.premiumFrequency = premiumFrequency;
        return this;
    }

    public String getPolicyStatus() {
        return policyStatus;
    }

    public PolicyDetails setPolicyStatus(String policyStatus) {
        this.policyStatus = policyStatus;
        return this;
    }
}