package com.kafka.Consumer.Kafka_Consumer.configuration;

import com.kafka.Consumer.Kafka_Consumer.constant.KafkaConstant;
import com.kafka.Consumer.Kafka_Consumer.model.Movie;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;


@EnableKafka
@Configuration
public class ConsumerConfiguration {
    @Bean
    public Map<String, Object> consumerConfig( ){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstant.BROKER);
        config.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaConstant.GROUP_ID);
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
        return config;
    }

    @Bean
    public ConsumerFactory<String, Movie> consumerFactory(){
        JsonDeserializer<Movie> deserializer = new JsonDeserializer<>(Movie.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        return new DefaultKafkaConsumerFactory<>(consumerConfig(), new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Movie> kafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, Movie> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}