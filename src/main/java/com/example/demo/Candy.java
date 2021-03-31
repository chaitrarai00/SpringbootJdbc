package com.example.demo;

public class Candy {
	
	public Candy(int id, String name, String composition) {
		super();
		this.id = id;
		this.name = name;
		this.composition = composition;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Candy(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "Candy [id=" + id + ", name=" + name + ", composition=" + composition + "]";
	}
	public Candy() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	private int id;
	private String name;
	private String composition;
}
