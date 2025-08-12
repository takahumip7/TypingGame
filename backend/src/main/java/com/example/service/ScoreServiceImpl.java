package com.example.service;

import org.springframework.stereotype.Service;

import com.example.entity.Score;
import com.example.mapper.ScoreMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService{

	private final ScoreMapper scoreMapper;

	@Override
	public void saveScore(Score score) {
		scoreMapper.insertScore(score);
	}
	
}
