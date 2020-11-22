package br.com.healthtrackfiap.test;

import java.sql.SQLException;

import br.com.healthtrackfiap.daos.BloodPressureDAO;
import br.com.healthtrackfiap.models.BloodPressure;
public class HTBloodPressureTest {
	
	public static void main(String[] args) throws SQLException {
		
		
		BloodPressureDAO daoPressure = new BloodPressureDAO();
		
		BloodPressure pressure1 = new BloodPressure();
		
		pressure1.setValueBloodPressure(15.13);
		boolean sucesso1 = daoPressure.InsertPressure(pressure1);
		
		System.out.println("sucesso : "+ sucesso1 );
		
		BloodPressure pressure2 = new BloodPressure();
		pressure2.setValueBloodPressure(10.12);
		boolean sucesso2 = daoPressure.InsertPressure(pressure2);
		
		System.out.println("sucesso : "+ sucesso2 );
		
		BloodPressure pressure3 = new BloodPressure();
		pressure3.setValueBloodPressure(11.9);
		boolean sucesso3 = daoPressure.InsertPressure(pressure3);
		
		System.out.println("sucesso : "+ sucesso3 );
		
		BloodPressure pressure4 = new BloodPressure();
		pressure4.setValueBloodPressure(12.07);
		boolean sucesso4 = daoPressure.InsertPressure(pressure4);
		
		System.out.println("sucesso : "+ sucesso4 );
		
		BloodPressure pressure5 = new BloodPressure();
		pressure5.setValueBloodPressure(11.10);
		boolean sucesso5 = daoPressure.InsertPressure(pressure5);
		
		System.out.println("sucesso : "+ sucesso5);
	}
	

}
