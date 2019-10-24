package com.csv.config;

import java.util.List;

import com.csv.base.BaseCsvReader;

public class TeacherConfigManager implements BaseConfigManager {

	private static final TeacherConfigManager instance = new TeacherConfigManager();

	private TeacherConfigManager() {

	}

	public static final TeacherConfigManager getInstance() {
		return instance;
	}

	@Override
	public void parse(String path) {
		List<TeacherConfig> list = BaseCsvReader.getInstance().readSheet(TeacherConfig.class, path);
		for (TeacherConfig config : list) {
			System.out.println(config.toString());
		}
	}

}
