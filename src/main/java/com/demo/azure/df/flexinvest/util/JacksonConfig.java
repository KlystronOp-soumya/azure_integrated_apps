package com.demo.azure.df.flexinvest.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public final class JacksonConfig {

    private JacksonConfig() {}

    public static ObjectMapper defaultObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());

        // Fail fast on unknown properties (helps catch API contract issues)
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Write dates in ISO-8601 format instead of timestamps
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // Include only non-null values in JSON
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // Optional: pretty-print for readability (disable in production if performance matters)
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        return mapper;
    }
}
