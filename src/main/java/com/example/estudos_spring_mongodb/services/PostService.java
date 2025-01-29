package com.example.estudos_spring_mongodb.services;

import com.example.estudos_spring_mongodb.domain.Post;
import com.example.estudos_spring_mongodb.repositories.PostRepository;
import com.example.estudos_spring_mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id){
        Optional<Post> post = postRepository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    };


}
