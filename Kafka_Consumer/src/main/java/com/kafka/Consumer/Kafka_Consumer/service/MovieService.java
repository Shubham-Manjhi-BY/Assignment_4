package com.kafka.Consumer.Kafka_Consumer.service;

import com.kafka.Consumer.Kafka_Consumer.model.Movie;
import com.kafka.Consumer.Kafka_Consumer.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

}
