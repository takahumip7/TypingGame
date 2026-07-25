package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "words")
@Getter
@Setter
public class Word {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動採番
	private int id;
	
	@Column(nullable = false)
	private String text;
}
