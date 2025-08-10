package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Score;
import com.example.mapper.ScoreMapper;

@Service
public class ScoreServiceImpl implements ScoreService{

	private final ScoreMapper scoreMapper;
	
	public ScoreServiceImpl(ScoreMapper scoreMapper) {
		this.scoreMapper = scoreMapper;
	}

	@Override
	public void saveScore(Score score) {
		scoreMapper.insertScore(score);
	}
	
}
