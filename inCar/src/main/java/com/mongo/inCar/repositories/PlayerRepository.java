package com.mongo.inCar.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongo.inCar.entities.PersionEntity;

public interface PlayerRepository extends MongoRepository<PersionEntity, Long>{

}
