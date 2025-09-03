package com.example.TravelAgency.dto;

import com.example.TravelAgency.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Long id;

    private String text;

    private Long userId;

    private Long postId;

    private LocalDateTime creationTime;

    public CommentDto(Comment comment){
        id = comment.getId();
        text = comment.getText();
        userId = comment.getUser().getId();
        postId = comment.getPost().getId();
        creationTime = comment.getCreationTime();


    }

}
