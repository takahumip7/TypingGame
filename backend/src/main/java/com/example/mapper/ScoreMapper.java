package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.entity.Score;

@Mapper
public interface ScoreMapper {

    @Insert("INSERT INTO scores (username, score) VALUES (#{username}, #{score})")
    void insertScore(Score score);
}
