package com.demo.azure.df.flexinvest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class InsurancePolicy {

    @JsonProperty("policyId")
    private UUID policyId;

    @JsonProperty("policyNumber")
    private String policyNumber;

    @JsonProperty("policyHolder")
    private PolicyHolder policyHolder;

    @JsonProperty("policyDetails")
    private PolicyDetails policyDetails;

    @JsonProperty("flexiInvest")
    private FlexInvest flexiInvest;

    @JsonProperty("nominees")
    private List<Nominee> nominees;

    @JsonProperty("brokerDetails")
    private Broker brokerDetails;

    public UUID getPolicyId() {
        return policyId;
    }

    public InsurancePolicy setPolicyId(UUID policyId) {
        this.policyId = policyId;
        return this;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public InsurancePolicy setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
        return this;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }

    public InsurancePolicy setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
        return this;
    }

    public PolicyDetails getPolicyDetails() {
        return policyDetails;
    }

    public InsurancePolicy setPolicyDetails(PolicyDetails policyDetails) {
        this.policyDetails = policyDetails;
        return this;
    }

    public FlexInvest getFlexiInvest() {
        return flexiInvest;
    }

    public InsurancePolicy setFlexiInvest(FlexInvest flexiInvest) {
        this.flexiInvest = flexiInvest;
        return this;
    }

    public List<Nominee> getNominees() {
        return nominees;
    }

    public InsurancePolicy setNominees(List<Nominee> nominees) {
        this.nominees = nominees;
        return this;
    }

    public InsurancePolicy brokerDetails(Broker brokerDetails) {
        this.brokerDetails = brokerDetails;
        return this;
    }

    public Broker getBrokerDetails() {
        return brokerDetails;
    }

    public void setBrokerDetails(Broker brokerDetails) {
        this.brokerDetails = brokerDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InsurancePolicy that)) {
            return false;
        }
        return Objects.equals(policyId, that.policyId)
                && Objects.equals(policyNumber, that.policyNumber)
                && Objects.equals(policyHolder, that.policyHolder)
                && Objects.equals(policyDetails, that.policyDetails)
                && Objects.equals(flexiInvest, that.flexiInvest)
                && Objects.equals(nominees, that.nominees)
                && Objects.equals(brokerDetails, that.brokerDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyId, policyNumber, policyHolder,
                policyDetails, flexiInvest, nominees, brokerDetails);
    }

    @Override
    public String toString() {
        return "InsurancePolicy{" +
                "policyId=" + policyId +
                ", policyNumber='" + policyNumber + '\'' +
                ", policyHolder=" + policyHolder +
                ", policyDetails=" + policyDetails +
                ", flexiInvest=" + flexiInvest +
                ", nominees=" + nominees +
                ", brokerDetails=" + brokerDetails +
                '}';
    }
}