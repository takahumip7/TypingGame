package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
}
