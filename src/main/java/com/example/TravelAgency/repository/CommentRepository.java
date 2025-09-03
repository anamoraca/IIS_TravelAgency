package com.example.TravelAgency.repository;

import com.example.TravelAgency.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
