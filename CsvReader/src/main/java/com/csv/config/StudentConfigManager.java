package com.csv.config;

import java.util.List;

import com.csv.base.BaseCsvReader;

public class StudentConfigManager implements BaseConfigManager {

	private static final StudentConfigManager instance = new StudentConfigManager();

	private StudentConfigManager() {
	}

	public static StudentConfigManager getInstance() {
		return instance;
	}

	@Override
	public void parse(String path) {
		List<StudentConfig> list = BaseCsvReader.getInstance().readSheet(StudentConfig.class, path);
		for (StudentConfig config : list) {
			System.out.println(config);
		}

	}

}
