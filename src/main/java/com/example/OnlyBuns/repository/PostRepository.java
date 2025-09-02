package com.example.OnlyBuns.repository;

import com.example.OnlyBuns.model.Post;
import com.example.OnlyBuns.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUserId(Long userId);

    @Query("SELECT p FROM Post p WHERE p.user.id = ?1")
    List<Post> findPostsByUserId(Long userId);

    @Query("SELECT p FROM Post p WHERE p.creationTime < :oneHourAgo")
    List<Post> findPostsOlderThanOneHour(LocalDateTime oneHourAgo);

}
