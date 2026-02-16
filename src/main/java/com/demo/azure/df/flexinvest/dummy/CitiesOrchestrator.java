package com.demo.azure.df.flexinvest.dummy;

import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.TaskOrchestrationContext;
import com.microsoft.durabletask.azurefunctions.DurableOrchestrationTrigger;

public class CitiesOrchestrator {

    /**
     * This is the orchestrator function, which can schedule activity functions, create durable timers,
     * or wait for external events in a way that's completely fault-tolerant.
     */
    @FunctionName("CitiesOrchestrator")
    public String citiesOrchestrator(
            @DurableOrchestrationTrigger(name = "taskOrchestrationContext") TaskOrchestrationContext ctx) {
        String result = "";
        result += ctx.callActivity("Capitalize", "Tokyo", String.class).await() + ", ";
        result += ctx.callActivity("Capitalize", "London", String.class).await() + ", ";
        result += ctx.callActivity("Capitalize", "Seattle", String.class).await() + ", ";
        result += ctx.callActivity("Capitalize", "Austin", String.class).await();
        return result;
    }
}
