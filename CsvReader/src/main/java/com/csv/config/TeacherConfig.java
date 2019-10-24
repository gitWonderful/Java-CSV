package com.csv.config;

import com.csv.annotation.ExcelField;

public class TeacherConfig {

	@ExcelField(name = "id")
	private int id;
	@ExcelField(name = "age")
	private byte age;
	@ExcelField(name = "certificate_number")
	private long certificateNumber;
	@ExcelField(name = "basic_salary")
	private float basicSalary;
	@ExcelField(name = "housing_allowance")
	private short housingAllowance;
	@ExcelField(name = "bonus")
	private double bonus;
	@ExcelField(name = "sex")
	private char sex;
	@ExcelField(name = "special_class")
	private boolean specialClass;
	@ExcelField(name = "graduate_institution")
	private String graduateInstitution;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public long getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(long certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public short getHousingAllowance() {
		return housingAllowance;
	}

	public void setHousingAllowance(short housingAllowance) {
		this.housingAllowance = housingAllowance;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public boolean isSpecialClass() {
		return specialClass;
	}

	public void setSpecialClass(boolean specialClass) {
		this.specialClass = specialClass;
	}

	public String getGraduateInstitution() {
		return graduateInstitution;
	}

	public void setGraduateInstitution(String graduateInstitution) {
		this.graduateInstitution = graduateInstitution;
	}

	@Override
	public String toString() {
		return "TeacherConfig [id=" + id + ", age=" + age + ", certificateNumber=" + certificateNumber
				+ ", basicSalary=" + basicSalary + ", housingAllowance=" + housingAllowance + ", bonus=" + bonus
				+ ", sex=" + sex + ", specialClass=" + specialClass + ", graduateInstitution=" + graduateInstitution
				+ "]";
	}

}
