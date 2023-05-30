package br.com.ricardobraga.blog.resources;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.ricardobraga.blog.entities.Post;

import br.com.ricardobraga.blog.services.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostResource {

    @Autowired
    PostService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public List<Post> findAll() {
        return service.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        try {

            return ResponseEntity.ok(service.findByID(id));
        } catch (NoSuchElementException e) {
            System.out.println("TESTE");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Post with id %d not found", id));
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PatchMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Post post) {
        try{

            service.update(id, post);
        } catch (NoSuchElementException e) {
            System.out.println("TESTE");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Post with id %d not found", id));
        }
    }
    
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public void insert(@RequestBody Post post) {

        service.insert(post);

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping
    public void deleteById(@RequestBody Post post) {

        service.deleteById(post.getId());

    }

}
