package com.kashkina.portfolio.kafka.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class JacksonDeserializer<T> implements Deserializer<T> {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private Class<T> type;

    public JacksonDeserializer(Class<T> type) {
        this.type = type;
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public T deserialize(String topic, byte[] data) {
        try {
            if (data == null) return null;
            return objectMapper.readValue(data, type);
        } catch (Exception e) {
            throw new RuntimeException("Kafka JSON serialization error", e);
        }
    }

    @Override
    public void close() {}
}