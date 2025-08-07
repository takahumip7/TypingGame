package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Word;
import com.example.service.WordService;

@RestController
public class WordApiController {

	private final WordService wordService;

	public WordApiController(WordService wordService) {
		this.wordService = wordService;
	}
	
	@GetMapping("/api/words")
	public List<Word> getWords() {
		return wordService.getWords();
	}
}
