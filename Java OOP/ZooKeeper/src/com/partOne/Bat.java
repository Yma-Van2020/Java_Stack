package com.partOne;

public class Bat extends Mammal {
	public Bat() {
		energyLevel = 300;
	}
	public void fly() {
		System.out.println("oof oof!");
		this.energyLevel -= 50;
	}
	public void eatHumans() {
		System.out.println("yummmmmm");
		this.energyLevel += 25;
	}
	public void attackTown() {
		System.out.println("hoooooo");
		this.energyLevel -= 100;
	}
}