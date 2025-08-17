package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Score;
import com.example.repository.ScoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService{

	private final ScoreRepository scoreRepository;

	@Override
	public void saveScore(Score score) {
		scoreRepository.save(score);
	}
	
}
