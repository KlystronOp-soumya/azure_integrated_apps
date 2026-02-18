package com.demo.azure.df.flexinvest.orchestrator;

import com.demo.azure.df.flexinvest.domain.DummyPolicy;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.TaskFailedException;
import com.microsoft.durabletask.TaskOrchestrationContext;
import com.microsoft.durabletask.azurefunctions.DurableOrchestrationTrigger;

public class FlexInvestPolicySubmissionOrchestration {

    @FunctionName("policySubmissionOrchestrator")
    public String policySubmissionOrchestrator(
            @DurableOrchestrationTrigger(name = "ctx") TaskOrchestrationContext ctx) {

        DummyPolicy input = ctx.getInput(DummyPolicy.class);

        String result = "";

        try {

            result = ctx.callActivity("brokerActivityCheckStep", input, String.class).await();

        } catch (TaskFailedException taskFailedException) {
            ctx.callActivity("brokerActivityCheckStep", input, String.class).await();
        }

        return "submissionOrchestrator " + result;
    }

}
