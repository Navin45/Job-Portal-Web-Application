package com.navin.joblisting_backend.repository;

import com.navin.joblisting_backend.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
