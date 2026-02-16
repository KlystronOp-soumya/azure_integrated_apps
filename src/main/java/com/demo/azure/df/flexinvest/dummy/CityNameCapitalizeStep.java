package com.demo.azure.df.flexinvest.dummy;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.durabletask.azurefunctions.DurableActivityTrigger;

public class CityNameCapitalizeStep {

    /**
     * This is the activity function that is invoked by the orchestrator function.
     */
    @FunctionName("CityNameCapitalizeStep")
    public String capitalize(@DurableActivityTrigger(name = "name") String name, final ExecutionContext context) {
        context.getLogger().info("Capitalizing: " .formatted( name));
        return name.toUpperCase();
    }
}
