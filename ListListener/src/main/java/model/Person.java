package model;

import java.io.Serializable;

public class Person implements Serializable {
	private String name;
	private String kana;
	private String gender;
	private String blood;
	
	
	public Person() {}
	
	public Person(String name, String kana, String gender, String blood) {
		super();
		this.name = name;
		this.kana = kana;
		this.gender = gender;
		this.blood = blood;
	}

	public String getName() {
		return name;
	}

	public String getKana() {
		return kana;
	}

	public String getGender() {
		return gender;
	}

	public String getBlood() {
		return blood;
	}
	

	
}
