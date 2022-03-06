package com.manju.learning.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.manju.learning.model.UserDetails;

@Repository
public interface UserRepository extends MongoRepository<UserDetails,Integer> {

}
