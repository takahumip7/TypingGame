package com.example.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.dto.RankingResponse;
import com.example.entity.Score;

public interface ScoreRepository extends JpaRepository<Score, Integer>{
	
	// ユーザーごとの最高スコアを降順で取得
	@Query("SELECT new com.example.dto.RankingResponse(s.user.username, MAX(s.score)) FROM Score s GROUP BY s.user.username ORDER BY MAX(s.score) DESC")
	List<RankingResponse> findRanking(Pageable pageable);
}
