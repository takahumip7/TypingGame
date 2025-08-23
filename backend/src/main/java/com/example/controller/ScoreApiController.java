package com.example.controller;

import java.time.LocalDateTime;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ScoreRequest;
import com.example.entity.Score;
import com.example.entity.User;
import com.example.repository.UserRepository;
import com.example.service.ScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // React側のURL
public class ScoreApiController {

	private final ScoreService scoreService;
	private final UserRepository userRepository;
	
	@PostMapping
	public String saveScore(@RequestBody ScoreRequest request, Authentication authentication) {
		
		// JWTからログイン中のユーザー名取得
		String username = authentication.getName();
		
		// ユーザー取得
		User user = userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
		
		// スコアにユーザーをセット
		Score score = new Score();
		score.setUser(user); // JWTから取得したユーザーを紐付け
		score.setScore(request.getScore()); // フロントから送られたスコアをセット
		score.setCreatedAt(LocalDateTime.now()); // サーバー側で保存時刻をセット
		
		// 保存
		scoreService.saveScore(score);
		return "Score saved successfully";
	}
}
