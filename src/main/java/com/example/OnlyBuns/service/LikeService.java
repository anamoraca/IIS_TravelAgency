package com.example.OnlyBuns.service;

import com.example.OnlyBuns.model.Comment;
import com.example.OnlyBuns.model.Like;
import com.example.OnlyBuns.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LikeService {
    @Autowired
    private LikeRepository likeRepository;

    public Like findById(Long id) {
        return likeRepository.findById(id).orElse(null);
    }


    public List<Like> findAll() {
        return likeRepository.findAll();
    }
    public List<Like> findAllById(List<Long> ids) {
        return likeRepository.findAllById(ids);
    }
}
