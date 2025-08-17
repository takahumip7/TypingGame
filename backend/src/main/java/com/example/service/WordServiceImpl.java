package com.example.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Word;
import com.example.repository.WordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService{

	private final WordRepository wordRepository;
	
	@Override
	public List<Word> getWords() {
		List<Word> words = wordRepository.findAll();
		Collections.shuffle(words); //ランダム順並び替え
		return words.stream().limit(10).toList(); //10件だけ残す
	}
}
