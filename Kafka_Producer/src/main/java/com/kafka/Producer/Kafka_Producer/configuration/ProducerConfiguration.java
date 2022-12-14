package com.kafka.Producer.Kafka_Producer.configuration;


import com.kafka.Producer.Kafka_Producer.constant.KafkaConstant;
import com.kafka.Producer.Kafka_Producer.model.Movie;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class ProducerConfiguration
{
    @Bean
    public Map<String, Object> producerConfig( ){
        Map<String,Object> config = new HashMap<>();
        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.BROKER); // Kafka Server URL
        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); // Data encoding for key
        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);// Data encoding for value
        System.out.println(config);
        return config;
    }
    @Bean
    public ProducerFactory<String, Movie> producerFactory()
    {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public KafkaTemplate<String, Movie> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }

}