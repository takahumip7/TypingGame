package com.example.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "scores")
public class Score {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY) // 遅延ロードでパフォーマンス確保
	@JoinColumn(name = "user_id", nullable = false) // users.id と外部キーで紐付け
	private User user;
	
	@Column(nullable = false)
	private int score;
	
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
