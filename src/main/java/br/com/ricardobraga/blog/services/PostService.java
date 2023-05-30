package br.com.ricardobraga.blog.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import br.com.ricardobraga.blog.entities.Post;
import br.com.ricardobraga.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    
    public List<Post> findAll() {

        return repository.findAll(Sort.by("id").descending());

    }



    public Post findByID(Long id) {

        return repository.findById(id).get();

    }

    
 

    
    public void insert(Post post) {
        
        Post newPost = new Post(null, post.getUsername(), Instant.now().plus(3, ChronoUnit.HOURS), post.getTitle(), post.getContent());
        repository.save(newPost);       

    }

    public void update(Long id, Post post){

        Post newPost = findByID(id);

        newPost.setTitle(post.getTitle());
        newPost.setContent(post.getContent());

        repository.save(newPost);
    }

    public void deleteById(Long id){
        
        repository.deleteById(id);

    }

    
}
