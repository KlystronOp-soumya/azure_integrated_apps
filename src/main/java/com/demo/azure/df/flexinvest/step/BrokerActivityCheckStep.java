package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.DummyPolicy;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class BrokerActivityCheckStep {

    @FunctionName("brokerActivityCheckStep")
    public String brokerActivityCheckStep(@DurableActivityTrigger(name = "input") DummyPolicy input,
                                          final ExecutionContext ctx) {

        ctx.getLogger().info("Broker Activity Check Step invoked.");

        if (input.getBrokerId().startsWith("INV")) {
            throw new IllegalStateException("Invalid broker id: " + input.getBrokerId());
        }

        return "SUCCESS";
    }

}
