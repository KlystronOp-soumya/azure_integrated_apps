package com.demo.azure.df.flexinvest.trigger;

import com.demo.azure.df.flexinvest.domain.DummyPolicy;
import com.demo.azure.df.flexinvest.domain.OrchestrationResponse;
import com.demo.azure.df.flexinvest.domain.Status;
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
import com.microsoft.durabletask.azurefunctions.DurableClientContext;
import com.microsoft.durabletask.azurefunctions.DurableClientInput;

import java.util.Optional;

import static com.demo.azure.df.flexinvest.util.JacksonConfig.defaultObjectMapper;

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

        DummyPolicy insurancePolicy = null;
        ObjectMapper objectMapper = defaultObjectMapper();

        String instanceId;

        try {
            if (request.getBody().isEmpty()) {
                Status status = new Status(false, true, "Invalid payload");
                OrchestrationResponse orchestrationResponse = new OrchestrationResponse(insurancePolicy, status);

                return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                        .body(orchestrationResponse)
                        .build();
            }

            String body = request.getBody().get();


            insurancePolicy = objectMapper.readValue(body, DummyPolicy.class);

            if (insurancePolicy == null) {

                Status status = new Status(false, true, "Invalid payload");
                OrchestrationResponse orchestrationResponse = new OrchestrationResponse(insurancePolicy, status);

                return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                        .body(orchestrationResponse)
                        .build();
            }

            DurableTaskClient taskClient = durableClientContext.getClient();

            instanceId = taskClient.scheduleNewOrchestrationInstance(
                    "policySubmissionOrchestrator",
                    insurancePolicy);

        } catch (JsonProcessingException e) {

            ctx.getLogger().warning("Invalid JSON: " + e.getMessage());

            return request.createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("Invalid JSON payload")
                    .build();

        } catch (Exception e) {

            ctx.getLogger().severe("Unexpected error: " + e.getMessage());

            Status status = new Status(false, true, "Invalid payload");
            OrchestrationResponse orchestrationResponse = new OrchestrationResponse(insurancePolicy, status);

            return request.createResponseBuilder(HttpStatus.EXPECTATION_FAILED)
                    .body(orchestrationResponse)
                    .build();
        }

        return durableClientContext.createCheckStatusResponse(request, instanceId);
    }

}
