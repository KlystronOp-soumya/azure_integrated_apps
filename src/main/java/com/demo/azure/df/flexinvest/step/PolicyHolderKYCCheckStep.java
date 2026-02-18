package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.InsurancePolicy;
import com.demo.azure.df.flexinvest.domain.PolicyHolder;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

import static com.demo.azure.df.flexinvest.util.LoggerUtil.dfInfo;

public final class PolicyHolderKYCCheckStep {

    private PolicyHolderKYCCheckStep() {}

    @FunctionName("policyHolderKYCCheckStep")
    public Boolean policyHolderKYCCheckStep(@DurableActivityTrigger(name = "policyHolderKYCCheck") PolicyHolder policyHolder,
                                            final ExecutionContext context) {

        dfInfo("Initiated policyHolderKYCCheckStep");
        dfInfo("PolicyHolder details: " + policyHolder.getCustomerId());

        return Boolean.TRUE;

    }
}
