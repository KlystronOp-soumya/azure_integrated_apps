package com.demo.azure.df.flexinvest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class FundAllocation {

    @JsonProperty("fundName")
    private String fundName;

    @JsonProperty("allocationPercentage")
    private BigDecimal allocationPercentage;

    @JsonProperty("nav")
    private BigDecimal nav;

    public String getFundName() {
        return fundName;
    }

    public FundAllocation setFundName(String fundName) {
        this.fundName = fundName;
        return this;
    }

    public BigDecimal getAllocationPercentage() {
        return allocationPercentage;
    }

    public FundAllocation setAllocationPercentage(BigDecimal allocationPercentage) {
        this.allocationPercentage = allocationPercentage;
        return this;
    }

    public BigDecimal getNav() {
        return nav;
    }

    public FundAllocation setNav(BigDecimal nav) {
        this.nav = nav;
        return this;
    }
}