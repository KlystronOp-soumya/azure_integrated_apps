package com.demo.azure.df.flexinvest.domain;

import java.util.Objects;

public class Broker {
    private String brokerId;

    private String brokerName;

    private String contactEmail;

    private String contactPhone;

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Broker broker)) {
            return false;
        }
        return Objects.equals(brokerId, broker.brokerId) && Objects.equals(brokerName, broker.brokerName) && Objects.equals(contactEmail, broker.contactEmail) && Objects.equals(contactPhone, broker.contactPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brokerId, brokerName, contactEmail, contactPhone);
    }

    @Override
    public String toString() {
        return "Broker{" +
                "brokerId='" + brokerId + '\'' +
                ", brokerName='" + brokerName + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}

