package jtm.activity03;

public class RandomPerson {

	// TODO Create _private_ structure of random person to store values:
	// name as String,
	// age as int,
	// weight as float,
	// isFemale as boolean;
	// smile as char
	// HINT: use Alt+Shift+A to switch to Block selection (multi-line cursor)
	// to edit list of all properties at once

	// TODO Select menu "Source — Generate Getters and Setters..." then select
	// all properties and generate _public_ getters and setters for all of them

	private String name;
	private int age;
	private float weight;
	private boolean isFemale;
	private char smile;

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void setFemale(boolean female) {
		this.isFemale = female;
	}

	public void setSmile(char smile) {
		this.smile = smile;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

	public float getWeight() {
		return this.weight;
	}

	public boolean isFemale() {
		return this.isFemale;
	}

	public char getSmile() {
		return this.smile;
	}

}
