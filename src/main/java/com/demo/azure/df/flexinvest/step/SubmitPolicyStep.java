package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.InsurancePolicy;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class SubmitPolicyStep {

    @FunctionName("submitFlexInvestPolicyStep")
    public InsurancePolicy submitFlexInvestPolicy(
            @DurableActivityTrigger(name = "policyDetails") InsurancePolicy insurancePolicy,
            final ExecutionContext context) {

        return insurancePolicy;
    }
}
