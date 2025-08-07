package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.entity.Word;

@Mapper
public interface WordMapper {

    @Select("SELECT * FROM words ORDER BY RAND() LIMIT 10")
    List<Word> getRandomWords();
}
