package com.demo.azure.df.flexinvest.domain;

public class OrchestrationFailedException extends RuntimeException {

    private String errorMessage;
    private Throwable cause;

    public OrchestrationFailedException(final String errorMessage, final Throwable cause) {
        super(errorMessage, cause);
    }

    public OrchestrationFailedException(final String errorMessage) {
        super(errorMessage);
    }
}
