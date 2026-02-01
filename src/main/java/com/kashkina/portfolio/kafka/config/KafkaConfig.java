package com.kashkina.portfolio.kafka.config;

import com.kashkina.portfolio.kafka.event.VisitEvent;
import com.kashkina.portfolio.kafka.serializer.JacksonDeserializer;
import com.kashkina.portfolio.kafka.serializer.JacksonSerializer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {

    private final String bootstrapServers = "localhost:29092";

    // ---------------- Producer ----------------
    @Bean
    public ProducerFactory<String, VisitEvent> visitEventProducerFactory() {
        Map<String, Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonSerializer.class); // Jackson сериализация
        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate<String, VisitEvent> visitEventKafkaTemplate() {
        return new KafkaTemplate<>(visitEventProducerFactory());
    }

    // ---------------- Consumer ----------------
    @Bean
    public ConsumerFactory<String, VisitEvent> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "visit-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JacksonDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props,
                new StringDeserializer(),
                new JacksonDeserializer<>(VisitEvent.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, VisitEvent> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, VisitEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
