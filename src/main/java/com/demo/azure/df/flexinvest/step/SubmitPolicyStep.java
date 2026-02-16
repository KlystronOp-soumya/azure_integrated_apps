package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.PolicyDetails;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class SubmitPolicyStep {

    @FunctionName("submitFlexInvestPolicy")
    public PolicyDetails submitFlexInvestPolicy(
            @DurableActivityTrigger(name = "policyDetails") PolicyDetails policyDetails,
            final ExecutionContext context) {

        return policyDetails;
    }
}
