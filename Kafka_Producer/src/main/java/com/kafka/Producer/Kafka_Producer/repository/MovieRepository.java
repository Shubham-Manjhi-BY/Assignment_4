package com.kafka.Producer.Kafka_Producer.repository;


import com.kafka.Producer.Kafka_Producer.model.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>
{

}
