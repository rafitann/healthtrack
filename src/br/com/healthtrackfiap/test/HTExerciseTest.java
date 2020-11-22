package br.com.healthtrackfiap.test;

import java.sql.SQLException;

import br.com.healthtrackfiap.daos.ExerciseDAO;
import br.com.healthtrackfiap.exception.DataIncorretaException;
import br.com.healthtrackfiap.models.Exercise;
import br.com.healthtrackfiap.utils.FormatadorData;

public class HTExerciseTest {
	
	public static void main(String[] args) throws SQLException, DataIncorretaException {
		
		ExerciseDAO daoExercise = new ExerciseDAO();
		
		Exercise exercise1 = new Exercise();
		
		exercise1.setLabel("Vôlei de Praia");
		
		exercise1.setDuration(FormatadorData.parseDate("10/11/2020"));  
		
		exercise1.setDescription("Vôlei de Praia com galere");
		
		boolean sucesso1 = daoExercise.InsertExercise(exercise1);
		
		System.out.println("Exercício1 : " + sucesso1);
		
		
		
		Exercise exercise2 = new Exercise();
		
		exercise2.setLabel("Basquete");
		
		exercise2.setDuration(FormatadorData.parseDate("25/10/2020"));  
		
		exercise2.setDescription("Basquete na quadra com a rapaziada");
		
		boolean sucesso2 = daoExercise.InsertExercise(exercise2);
		
		System.out.println("Exercício2 : " + sucesso2);
		
		
		
        Exercise exercise3 = new Exercise();
		
		exercise3.setLabel("Kart");
		
		exercise3.setDuration(FormatadorData.parseDate("15/10/2020"));  
		
		exercise3.setDescription("Passeio agradável com a familía.");
		
		boolean sucesso3 = daoExercise.InsertExercise(exercise3);
		
		System.out.println("Exercício3 : " + sucesso3);
		
		
        Exercise exercise4 = new Exercise();
		
		exercise4.setLabel("Futebol");
		
		exercise4.setDuration(FormatadorData.parseDate("05/10/2020"));  
		
		exercise4.setDescription("Peladinha com os amigos");
		
		boolean sucesso4 = daoExercise.InsertExercise(exercise4);
		
		System.out.println("Exercício4 : " + sucesso4);
		
		
		 Exercise exercise5 = new Exercise();
			
			exercise5.setLabel("Corrida");
			
			exercise5.setDuration(FormatadorData.parseDate("18/10/2020"));  
			
			exercise5.setDescription("Brisa de verão em Buzios");
			
			boolean sucesso5 = daoExercise.InsertExercise(exercise5);
			
			System.out.println("Exercício5 : " + sucesso5);
	}

}
