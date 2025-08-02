package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Word;

@Mapper
public interface WordMapper {

	List<Word> getRandomWords();
}
