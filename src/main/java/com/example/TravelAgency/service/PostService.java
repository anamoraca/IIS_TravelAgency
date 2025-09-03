package com.example.TravelAgency.service;

import com.example.TravelAgency.dto.PostDto;
import com.example.TravelAgency.model.Location;
import com.example.TravelAgency.model.Post;
import com.example.TravelAgency.model.User;
import com.example.TravelAgency.repository.PostRepository;
import com.example.TravelAgency.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    private final Path root = Paths.get("src/main/resources/static/pictures");

    public PostService() {
        try {
            // Ensure the directory exists
            Files.createDirectories(root);
        } catch (Exception e) {
            throw new RuntimeException("Could not create upload folder!", e);
        }
    }

    public Post findById(Long id) {
        return postRepository.findById(id).orElse(null);
    }

    public Post create(PostDto postDto, String username){

        User loggedUser = userRepository.findByUsername(username);
        if(loggedUser == null){
            return null;
        }
        Post post = new Post();
        post.setDescription(postDto.getDescription());

        Location location = new Location(null, postDto.getAddress(), postDto.getLongitude(), postDto.getLatitude());
        post.setLocation(location);

        post.setCreationTime(LocalDateTime.now());
        post.setLikes(0);
        post.setUser(loggedUser);


        MultipartFile image = postDto.getImage();
        if (image != null && !image.isEmpty()) {
            String imageUrl = saveMultipartFileToFolder(image);
            post.setImage(imageUrl);
        }


        postRepository.save(post);
        return post;
    }


    public List<Post> findAll() {
        return postRepository.findAll();
    }
    public List<Post> findAllById(List<Long> ids) {
        return postRepository.findAllById(ids);
    }



    public String saveMultipartFileToFolder(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file.");
            }

            Path destinationFile = this.root.resolve(file.getOriginalFilename()).normalize();

            file.transferTo(destinationFile.toAbsolutePath());

            return "static/pictures/" + file.getOriginalFilename();

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file.", e);
        }
    }

    public void updateCompressedUrls(){
        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
        List<Post> posts = postRepository.findPostsOlderThanOneHour(oneHourAgo);
        for (Post post : posts) {
            String imagePath = post.getImage();

            if (imagePath != null && !imagePath.isEmpty()) {
                int dotIndex = imagePath.lastIndexOf('.');
                if (dotIndex > 0) {
                    // Create the new path with "_compressed" before the file extension
                    String compressedImagePath = imagePath.substring(0, dotIndex) + "_compressed" + imagePath.substring(dotIndex);
                    post.setImage(compressedImagePath);
                }
            }
        }
        postRepository.saveAll(posts);
    }

}
