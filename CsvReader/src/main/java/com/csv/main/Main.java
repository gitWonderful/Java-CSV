package com.csv.main;

import com.csv.config.StudentConfigManager;
import com.csv.config.TeacherConfigManager;

public class Main {

	public void test() {
		String path = this.getClass().getResource("/").getPath();
		StudentConfigManager.getInstance().parse(path + "student.csv");
		TeacherConfigManager.getInstance().parse(path + "teacher.csv");
	}

	public static void main(String[] args) {
		new Main().test();
	}
}
