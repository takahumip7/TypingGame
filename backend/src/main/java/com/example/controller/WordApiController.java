package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Word;
import com.example.service.WordService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class WordApiController {

	private final WordService wordService;
	
	@GetMapping("/api/words")
	public List<Word> getWords() {
		return wordService.getWords();
	}
}
