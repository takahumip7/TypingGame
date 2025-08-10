package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Score;
import com.example.service.ScoreService;

@RestController
public class ScoreApiController {

	private final ScoreService scoreService;

	public ScoreApiController(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	@PostMapping("/api/scores")
	public ResponseEntity<String> postScore(@RequestBody Score score) {
		scoreService.saveScore(score);
		return new ResponseEntity<>("スコア保存成功", HttpStatus.OK);
	}
}
