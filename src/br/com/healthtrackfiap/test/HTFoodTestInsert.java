package br.com.healthtrackfiap.test;


import java.sql.SQLException;

import br.com.healthtrackfiap.daos.FoodDAO;
import br.com.healthtrackfiap.models.Food;

public class HTFoodTestInsert {
	
	public static void main(String[] args) throws SQLException {
		
		
		FoodDAO dao = new FoodDAO();
		
		Food food1 = new Food();
		
		food1.setCalories(50.9);
		food1.setDescription("comida vegetariana");
        boolean sucesso = dao.InsertFood(food1);
        
		System.out.println("food1: "+ sucesso );
		
		Food food2 = new Food();
		
		food2.setCalories(90.1);
		food2.setDescription("macarrão com queijo e presunto");
        boolean sucesso2 = dao.InsertFood(food2);
        
        System.out.println("food2: "+ sucesso2 );
        
        Food food3 = new Food();
        
        food3.setCalories(100.1);
		food3.setDescription("macarrão com salsicha");
        boolean sucesso3 = dao.InsertFood(food3);
        
        System.out.println("food3: "+ sucesso3 );
		
        Food food4 = new Food();
        
        food4.setCalories(100.1);
		food4.setDescription("macarrão com queijo");
        boolean sucesso4 = dao.InsertFood(food4);
        
        System.out.println("food4: "+ sucesso4 );
        
        Food food5 = new Food();
        
        food5.setCalories(35.5);
		food5.setDescription("sushi");
        boolean sucesso5 = dao.InsertFood(food5);
        
        System.out.println("food5: "+ sucesso5 );
     

	}
	

}
