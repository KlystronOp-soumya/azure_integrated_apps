package com.demo.azure.df.flexinvest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class FlexInvest {

    @JsonProperty("fundValue")
    private BigDecimal fundValue;

    @JsonProperty("riskProfile")
    private String riskProfile;

    @JsonProperty("allocations")
    private List<FundAllocation> allocations;

    public BigDecimal getFundValue() {
        return fundValue;
    }

    public FlexInvest setFundValue(BigDecimal fundValue) {
        this.fundValue = fundValue;
        return this;
    }

    public String getRiskProfile() {
        return riskProfile;
    }

    public FlexInvest setRiskProfile(String riskProfile) {
        this.riskProfile = riskProfile;
        return this;
    }

    public List<FundAllocation> getAllocations() {
        return allocations;
    }

    public FlexInvest setAllocations(List<FundAllocation> allocations) {
        this.allocations = allocations;
        return this;
    }
}
