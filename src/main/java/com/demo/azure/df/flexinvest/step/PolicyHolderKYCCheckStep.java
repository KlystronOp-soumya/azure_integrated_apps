package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.PolicyHolder;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class PolicyHolderKYCCheckStep {

    @FunctionName("policyHolderKYCCheckStep")
    public Boolean policyHolderKYCCheckStep(@DurableActivityTrigger(name = "policyHolderKYCCheck") PolicyHolder policyHolder,
                                            final ExecutionContext context) {

        return Boolean.TRUE;

    }
}
