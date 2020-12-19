package com.nosto.model;

public class Rate {
	
	private String name;
	private float value;
	
	public Rate() {}
	
	public Rate(String name, float value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getValue() {
		return this.value;
	}
}
