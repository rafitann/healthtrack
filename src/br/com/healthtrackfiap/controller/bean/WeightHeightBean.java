package br.com.healthtrackfiap.controller.bean;

import java.util.Date;

import br.com.healthtrackfiap.utils.FormatadorData;
import br.com.healthtrackfiap.utils.FormatadorNumero;

public class WeightHeightBean {

	private String id;
	private String height;
	private String weight;
	private String bmi;
	private String bmiClassification;
	private String createdAt;

	public WeightHeightBean() {
	}

	public WeightHeightBean(String idImc, double height, double weight, Date createdAt) {
		setId(idImc);
		try {
			setHeight(FormatadorNumero.toNumber(height, 2));
			setWeight(FormatadorNumero.toNumber(weight, 2));
			setCreatedAt(FormatadorData.toDate(createdAt));
		} catch (Exception e) {
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getBmiClassification() {
		return bmiClassification;
	}

	public void setBmiClassification(String bmiClassification) {
		this.bmiClassification = bmiClassification;
	}
}
