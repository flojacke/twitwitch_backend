package com.frey.quitter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frey.quitter.dto.PostRequest;
import com.frey.quitter.dto.PostResponse;
import com.frey.quitter.service.PostService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/posts/")
public class PostController {

	@Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable("id") Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    @GetMapping("by-subquitter/{id}")
    public ResponseEntity<List<PostResponse>> getPostsBySubQuitter(@PathVariable("id") Long id) {
        return status(HttpStatus.OK).body(postService.getPostsBySubQuitter(id));
    }

    @GetMapping("by-user/{name}")
    public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable("name") String username) {
        return status(HttpStatus.OK).body(postService.getPostsByUsername(username));
    }
}
