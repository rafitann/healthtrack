package br.com.healthtrackfiap.models;

import java.io.Serializable;

public class BloodPressure implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idBloodPressure;
	private double valueBloodPressure;
		
	public int getIdBloodPressure() {
		return idBloodPressure;
	}
	public void setIdBloodPressure(int idBloodPressure) {
		this.idBloodPressure = idBloodPressure;
	}
	public double getValueBloodPressure() {
		return valueBloodPressure;
	}
	public void setValueBloodPressure(double valueBloodPressure) {
		this.valueBloodPressure = valueBloodPressure;
	}
	

}
