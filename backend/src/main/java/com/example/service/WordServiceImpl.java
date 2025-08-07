package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Word;
import com.example.mapper.WordMapper;

@Service
public class WordServiceImpl implements WordService{

	private final WordMapper wordMapper;
	
	public WordServiceImpl(WordMapper wordMapper) {
		this.wordMapper = wordMapper;
	}

	@Override
	public List<Word> getWords() {
		return wordMapper.getRandomWords();
	}
}
