package com.demo.azure.df.flexinvest.domain;

import java.util.Objects;

public class DummyPolicy {

    private String policyId;

    private String holderName;

    private String startDate;

    private String endDate;

    private double premiumAmount;

    private String brokerName;

    private String brokerId;

    public DummyPolicy() {
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DummyPolicy that)) {
            return false;
        }
        return Double.compare(premiumAmount, that.premiumAmount) == 0
                && Objects.equals(policyId, that.policyId)
                && Objects.equals(holderName, that.holderName)
                && Objects.equals(startDate, that.startDate)
                && Objects.equals(endDate, that.endDate)
                && Objects.equals(brokerName, that.brokerName)
                && Objects.equals(brokerId, that.brokerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyId, holderName, startDate, endDate, premiumAmount, brokerName, brokerId);
    }

    @Override
    public String toString() {
        return "DummyPolicy{" +
                "policyId='" + policyId + '\'' +
                ", holderName='" + holderName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", premiumAmount=" + premiumAmount +
                ", brokerName='" + brokerName + '\'' +
                ", brokerId='" + brokerId + '\'' +
                '}';
    }
}
