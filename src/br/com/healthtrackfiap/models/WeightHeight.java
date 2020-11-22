package br.com.healthtrackfiap.models;

import java.io.Serializable;
import java.util.Date;

public class WeightHeight implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private  String idWeightHeight;
	private Double height;
	private Double weight;
	private Date createdAt;
	
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getIdImc() {
		return idWeightHeight;
	}
	public void setIdImc(String idImc) {
		this.idWeightHeight = idImc;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	

}
