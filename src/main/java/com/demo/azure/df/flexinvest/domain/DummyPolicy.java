package com.demo.azure.df.flexinvest.domain;

public class DummyPolicy {

    private String policyId;

    private String holderName;

    private String startDate;

    private String endDate;

    private double premiumAmount;

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

    @Override
    public String toString() {
        return "DummyPolicy{" +
                "policyId='" + policyId + '\'' +
                ", holderName='" + holderName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}
