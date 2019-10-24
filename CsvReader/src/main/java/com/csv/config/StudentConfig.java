package com.csv.config;

import com.csv.annotation.ExcelField;

public class StudentConfig {
	@ExcelField
	private int id;
	@ExcelField(name = "name")
	private String name;
	@ExcelField(name = "score")
	private int score;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "StudentConfig [id=" + id + ", name=" + name + ", score=" + score + "]";
	}

}
