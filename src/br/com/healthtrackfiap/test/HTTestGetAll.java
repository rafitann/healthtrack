package br.com.healthtrackfiap.test;

import br.com.healthtrackfiap.daos.FoodDAO;

import br.com.healthtrackfiap.daos.WeightHeightDAO;
import br.com.healthtrackfiap.models.Food;
import br.com.healthtrackfiap.models.WeightHeight;
import br.com.healthtrackfiap.models.BloodPressure;
import br.com.healthtrackfiap.models.Exercise;
import br.com.healthtrackfiap.daos.ExerciseDAO;
import br.com.healthtrackfiap.daos.BloodPressureDAO;


public class HTTestGetAll {
	public static void main(String[] args) {
		
		FoodDAO dao = new FoodDAO();
		
		BloodPressureDAO daoPressure = new BloodPressureDAO();
		
		WeightHeightDAO daoImc = new WeightHeightDAO();
		
		ExerciseDAO daoExercise = new ExerciseDAO();
	
		
		for(Food food: dao.getAll()) {
			System.out.println("IdComida : " + food.getId_food());
			System.out.println("Calorias : " + food.getCalories());
			System.out.println("Nome e Descrição:"+ food.getDescription());
			
		}
		
		for (BloodPressure pressure: daoPressure.getAll()) {
			System.out.println("IdPressão Arterial : " + pressure.getIdBloodPressure());
			System.out.println("Pressão Arterial : " + pressure.getValueBloodPressure());
		}
		
		for(WeightHeight imc: daoImc.getAll()) {
			System.out.println("Peso: " + imc.getWeight());
			System.out.println("Altura: " + imc.getHeight());
		}
		
		for(Exercise exercise: daoExercise.getAll()) {
			System.out.println("Esporte: " + exercise.getLabel());
			System.out.println("Descrição : " + exercise.getDescription());
		}
			
		}
			
		
	}

