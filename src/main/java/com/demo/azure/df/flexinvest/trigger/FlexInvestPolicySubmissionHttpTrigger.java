package com.demo.azure.df.flexinvest.trigger;

import com.demo.azure.df.flexinvest.domain.DummyPolicy;
import com.demo.azure.df.flexinvest.util.JacksonConfig;
import com.demo.azure.df.flexinvest.util.LoggerUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.durabletask.DurableTaskClient;
import com.microsoft.durabletask.NewOrchestrationInstanceOptions;
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
                    route = "submitPolicy"
            ) HttpRequestMessage<Optional<String>> request,
            @DurableClientInput(name = "durableContext") DurableClientContext durableClientContext,
            final ExecutionContext ctx) {

        DummyPolicy insurancePolicy;
        ObjectMapper objectMapper = JacksonConfig.defaultObjectMapper();
        LoggerUtil.init(ctx.getLogger());

        try {
            if (request.getBody().isEmpty()) {
                return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                        .body("Request body is missing")
                        .build();
            }

            String body = request.getBody().get();
            dfInfo("Received request body: " + body);

            insurancePolicy = objectMapper.readValue(body, DummyPolicy.class);

        } catch (JsonProcessingException e) {

            ctx.getLogger().warning("Invalid JSON: " + e.getMessage());

            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Invalid JSON payload")
                    .build();

        } catch (Exception e) {

            ctx.getLogger().severe("Unexpected error: " + e.getMessage());

            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Internal server error")
                    .build();
        }

        if (insurancePolicy == null) {
            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Invalid policy payload")
                    .build();
        }

        DurableTaskClient taskClient = durableClientContext.getClient();
        String instanceId;

        try {
            instanceId = taskClient.scheduleNewOrchestrationInstance(
                    "policySubmissionOrchestrator",
                    insurancePolicy
            );

        } catch (Exception e) {

            ctx.getLogger().severe("Orchestration start failed: " + e.getMessage());

            return request.createResponseBuilder(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Could not start orchestration")
                    .build();
        }

        return durableClientContext.createCheckStatusResponse(request, instanceId);
    }

}
