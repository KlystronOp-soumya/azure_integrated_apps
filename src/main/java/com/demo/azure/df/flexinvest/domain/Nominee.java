package com.demo.azure.df.flexinvest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Nominee {

    @JsonProperty("name")
    private String name;

    @JsonProperty("relationship")
    private String relationship;

    @JsonProperty("sharePercentage")
    private BigDecimal sharePercentage;

    public String getName() {
        return name;
    }

    public Nominee setName(String name) {
        this.name = name;
        return this;
    }

    public String getRelationship() {
        return relationship;
    }

    public Nominee setRelationship(String relationship) {
        this.relationship = relationship;
        return this;
    }

    public BigDecimal getSharePercentage() {
        return sharePercentage;
    }

    public Nominee setSharePercentage(BigDecimal sharePercentage) {
        this.sharePercentage = sharePercentage;
        return this;
    }
}