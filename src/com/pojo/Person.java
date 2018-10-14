package com.pojo;

import java.util.Calendar;

public abstract class Person {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public Calendar getDob() {
		return dob;
	}

	public void setDob(Calendar dob) {
		this.dob = dob;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBloodGrp() {
		return bloodGrp;
	}

	public void setBloodGrp(String bloodGrp) {
		this.bloodGrp = bloodGrp;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	String name;
	int personId;
	Calendar dob;
	String nationality;
	String bloodGrp;
	String insuranceNumber;
	
	public Person(String name, Calendar dob, String nationality, String bloodGrp, String insuranceNumber) {
		super();
		this.name = name;
		this.dob = dob;
		this.nationality = nationality;
		this.bloodGrp = bloodGrp;
		this.insuranceNumber = insuranceNumber;
		this.personId = (int )(Math.random() * 50 + 1);
	}
	
}
