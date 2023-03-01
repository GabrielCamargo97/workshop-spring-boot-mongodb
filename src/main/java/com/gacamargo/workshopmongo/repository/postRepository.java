package com.gacamargo.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gacamargo.workshopmongo.domain.Post;

@Repository
public interface postRepository extends MongoRepository<Post, String>{

}
