package com.demo.azure.df.flexinvest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PolicyHolder {

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("dateOfBirth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    public String getCustomerId() {
        return customerId;
    }

    public PolicyHolder setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public PolicyHolder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public PolicyHolder setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public PolicyHolder setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public PolicyHolder setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}