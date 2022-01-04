package com.example.API.Restful.with.Spring.Boot.and.MongoDB.repositories;

import com.example.API.Restful.with.Spring.Boot.and.MongoDB.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
}
