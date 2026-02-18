package com.demo.azure.df.flexinvest.step;

import com.demo.azure.df.flexinvest.domain.DummyPolicy;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

import static com.demo.azure.df.flexinvest.util.LoggerUtil.dfInfo;
import static com.demo.azure.df.flexinvest.util.LoggerUtil.init;

public class BrokerActivityCheckStep {

    @FunctionName("brokerActivityCheckStep")
    public String brokerActivityCheckStep(@DurableActivityTrigger(name = "input") DummyPolicy input,
                                          final ExecutionContext ctx) {
        init(ctx.getLogger());

        dfInfo("Inside brokerActivityCheckStep " + input);

        return input.toString();

    }

}
