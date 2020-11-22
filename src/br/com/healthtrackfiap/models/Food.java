package br.com.healthtrackfiap.models;

import java.io.Serializable;

public class Food implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idfood;
	private double calories;
	private String description;

	public int getId_food() {
		return idfood;
	}

	public void setId_food(int id_food) {
		this.idfood = id_food;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
