package com.example.OnlyBuns.dto;

import com.example.OnlyBuns.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Long id;

    private String description;


    private MultipartFile image;

    private String address;
    private double longitude;

    private double latitude;

    private LocalDateTime creationTime;


    private int likes;

    public PostDto(Post post){
        id = post.getId();
        description = post.getDescription();
        address = post.getLocation().getAddress();
        latitude = post.getLocation().getLatitude();
        longitude = post.getLocation().getLongitude();
        creationTime = post.getCreationTime();
        likes = post.getLikes();
    }

}
