package com.example.TravelAgency.service;

import com.example.TravelAgency.model.Like;
import com.example.TravelAgency.repository.LikeRepository;
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
