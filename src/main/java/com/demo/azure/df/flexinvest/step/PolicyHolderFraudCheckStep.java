package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.PolicyHolder;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class PolicyHolderFraudCheckStep {

    @FunctionName("policyHolderFraudCheckStep")
    public Boolean policyHolderFraudCheckStep(@DurableActivityTrigger(name = "policyHolderFraudCheck") PolicyHolder policyHolder,
                                              final ExecutionContext context) {

        return Boolean.TRUE;

    }
}
