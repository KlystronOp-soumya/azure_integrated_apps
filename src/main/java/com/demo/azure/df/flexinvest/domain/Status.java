package com.demo.azure.df.flexinvest.domain;

public record Status (boolean isSuccess, boolean hasErrors, String errorMessage, Exception exception) {

}
