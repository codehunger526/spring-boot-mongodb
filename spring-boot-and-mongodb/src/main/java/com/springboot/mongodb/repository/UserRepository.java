package com.springboot.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.springboot.mongodb.entity.UserEntity;

/* 
 *Implemented by shailendra
*/

public interface UserRepository extends MongoRepository<UserEntity, String> {

}
