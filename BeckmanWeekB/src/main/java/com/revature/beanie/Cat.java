package com.revature.beanie;

import java.io.Serializable;

import com.revature.list.AdoptionList;
import com.revature.loggy.FileThoseCats;
import com.revature.loggy.LogDaCats;

public class Cat implements Serializable {

	private static final long serialVersionUID = -1570163452581882436L;
	
	private String name;
	private String breed;
	private String furColor;
	private String gender;
	private int age;
	
	public Cat() {
		super();
		AdoptionList.adoptionList.add(this);
		FileThoseCats.writeAdoptionFile(AdoptionList.adoptionList);
	}
	public Cat(String name, String breed, String furColor, String gender, int age) {
		super();
		this.name = name;
		this.breed = breed;
		this.furColor = furColor;
		this.gender = gender;
		this.age = age;
		
		AdoptionList.adoptionList.add(this);
		FileThoseCats.writeAdoptionFile(AdoptionList.adoptionList);
		LogDaCats.LogIt("info", "A new cat, " + this.getName() + " has been put up for adoption.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getFurColor() {
		return furColor;
	}
	public void setFurColor(String furColor) {
		this.furColor = furColor;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", breed=" + breed + ", furColor=" + furColor + ", gender=" + gender + ", age="
				+ age + "]";
	}

	
}
