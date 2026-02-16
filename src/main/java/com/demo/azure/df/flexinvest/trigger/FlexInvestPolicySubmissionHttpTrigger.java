package com.demo.azure.df.flexinvest.trigger;

import com.demo.azure.df.flexinvest.domain.PolicyDetails;
import com.demo.azure.df.flexinvest.util.LoggerUtil;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.durabletask.DurableTaskClient;
import com.microsoft.durabletask.azurefunctions.DurableClientContext;
import com.microsoft.durabletask.azurefunctions.DurableClientInput;

import java.util.Optional;

import static com.demo.azure.df.flexinvest.util.LoggerUtil.dfInfo;

public final class FlexInvestPolicySubmissionHttpTrigger {

    @FunctionName("policySubmissionHttpTrigger")
    public HttpResponseMessage initPolicySubmission(
            @HttpTrigger(
                    name = "policySubmissionRequest",
                    authLevel = AuthorizationLevel.ANONYMOUS,
                    dataType = "",
                    methods = HttpMethod.POST,
                    route = "/submitPolicy"
            ) HttpRequestMessage<Optional<PolicyDetails>> request,
            @DurableClientInput(name = "durableContext") DurableClientContext durableClientContext,
            final ExecutionContext ctx) {

        LoggerUtil.init(ctx.getLogger());

        dfInfo("[INVEST] policySubmissionHttpTrigger");

        DurableTaskClient taskClient = durableClientContext.getClient();

        String instanceId = taskClient.scheduleNewOrchestrationInstance("policySubmissionOrchestrator");

        dfInfo("Orchestration instance scheduled");

        return durableClientContext.createCheckStatusResponse(request, instanceId);

    }

}
