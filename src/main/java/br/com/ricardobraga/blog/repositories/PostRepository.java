package br.com.ricardobraga.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ricardobraga.blog.entities.Post;
import java.util.List;
import java.time.Instant;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  
    
    
}
