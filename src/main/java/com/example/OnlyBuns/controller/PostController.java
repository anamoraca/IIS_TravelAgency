package com.example.OnlyBuns.controller;

import com.example.OnlyBuns.dto.PostDto;
import com.example.OnlyBuns.model.Post;
import com.example.OnlyBuns.model.User;
import com.example.OnlyBuns.security.auth.TokenBasedAuthentication;
import com.example.OnlyBuns.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/posts", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
    @Autowired
    private PostService postService;


    @GetMapping("")
    //@PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(this.postService.findAll(), HttpStatus.OK);
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<PostDto> createPost(@ModelAttribute PostDto postDto, Principal user){

        String username = user.getName();

        Post post = postService.create(postDto, username);
        if(post == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        PostDto dto = new PostDto(post);
        return new ResponseEntity<PostDto>(dto, HttpStatus.CREATED);
    }



}
