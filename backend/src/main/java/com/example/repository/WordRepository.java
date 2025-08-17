package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Word;

public interface WordRepository extends JpaRepository<Word, Integer>{
	
}
