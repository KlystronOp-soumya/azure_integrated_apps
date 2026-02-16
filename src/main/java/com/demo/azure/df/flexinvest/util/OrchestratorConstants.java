package com.demo.azure.df.flexinvest.util;

public enum OrchestratorConstants {

    POLICY_SUBMISSION_TRIGGER("policySubmissionHttpTrigger"),
    POLICY_SUBMISSION_ORCHESTRATOR("policySubmissionOrchestrator");

    private String value;

    OrchestratorConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
