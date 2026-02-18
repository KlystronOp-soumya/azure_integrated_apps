package com.demo.azure.df.flexinvest.util;

import com.microsoft.durabletask.RetryPolicy;
import com.microsoft.durabletask.TaskOptions;

import java.time.Duration;

public final class DefaultRetryPolicy {

    private DefaultRetryPolicy() {
    }

    public RetryPolicy getDefaultRetryPolicy() {
        final int maxAttempts = 3;
        final Duration firstRetryInterval = Duration.ofSeconds(5);
        RetryPolicy policy = new RetryPolicy(maxAttempts, firstRetryInterval);
        return policy;
    }

    public TaskOptions getDefaultTaskOptions() {

        return new TaskOptions(getDefaultRetryPolicy());
    }
}
