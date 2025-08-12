package com.example.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Score;
import com.example.service.ScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // React側のURL
public class ScoreApiController {

	private final ScoreService scoreService;
	
	@PostMapping
	public String saveScore(@RequestBody Score score) {
		scoreService.saveScore(score);
		return "Score saved successfully";
	}
}
