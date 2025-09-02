package com.example.OnlyBuns.service;

import com.example.OnlyBuns.dto.CommentDto;
import com.example.OnlyBuns.dto.PostDto;
import com.example.OnlyBuns.model.Comment;
import com.example.OnlyBuns.model.Post;
import com.example.OnlyBuns.model.User;
import com.example.OnlyBuns.repository.CommentRepository;
import com.example.OnlyBuns.repository.PostRepository;
import com.example.OnlyBuns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment create(CommentDto commentDto, User loggedUser){
        loggedUser = userRepository.findById(commentDto.getUserId()).orElse(null);
        if(loggedUser == null){
          return null;
        }
        Post activePost = postRepository.findById(commentDto.getPostId()).orElse(null);
        if(activePost == null){
            return null;
        }
        Comment comment = new Comment();
        comment.setText(commentDto.getText());
        comment.setUser(loggedUser);
        comment.setPost(activePost);
        comment.setCreationTime(LocalDateTime.now());
        commentRepository.save(comment);
        return comment;

    }
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
    public List<Comment> findAllById(List<Long> ids) {
        return commentRepository.findAllById(ids);
    }
}
