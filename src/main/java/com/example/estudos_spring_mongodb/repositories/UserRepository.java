package com.example.estudos_spring_mongodb.repositories;

import com.example.estudos_spring_mongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
