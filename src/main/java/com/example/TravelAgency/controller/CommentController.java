package com.example.TravelAgency.controller;

import com.example.TravelAgency.dto.CommentDto;
import com.example.TravelAgency.model.Comment;
import com.example.TravelAgency.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/comments", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public ResponseEntity<List<Comment>> getAll() {
        return new ResponseEntity<>(this.commentService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<CommentDto> createPost(@RequestBody CommentDto commentDto){
        Comment comment = commentService.create(commentDto, null);
        if(comment == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        CommentDto dto = new CommentDto(comment);
        return new ResponseEntity<CommentDto>(dto, HttpStatus.CREATED);
    }
}
