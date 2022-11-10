package com.kafka.Consumer.Kafka_Consumer.listener;

import com.kafka.Consumer.Kafka_Consumer.constant.KafkaConstant;
import com.kafka.Consumer.Kafka_Consumer.model.Movie;
import com.kafka.Consumer.Kafka_Consumer.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    MovieRepository movieRepository;

    @KafkaListener(topics = KafkaConstant.TOPIC, groupId = KafkaConstant.GROUP_ID)
    public void consume(Movie movie)
    {
        System.out.println(movie);
        movieRepository.save(movie);
    }
}