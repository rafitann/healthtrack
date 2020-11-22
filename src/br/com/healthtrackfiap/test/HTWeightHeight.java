package br.com.healthtrackfiap.test;

import java.sql.SQLException;
import java.util.Date;

import br.com.healthtrackfiap.daos.WeightHeightDAO;
import br.com.healthtrackfiap.models.WeightHeight;

public class HTWeightHeight {
	
	public static void main(String[] args) throws SQLException {

		WeightHeightDAO daoWh = new WeightHeightDAO();

		WeightHeight wh1 = new WeightHeight();

		wh1.setHeight(1.75);
		wh1.setWeight(90.9);
		wh1.setCreatedAt(new Date());
		boolean sucesso1 = daoWh.insertWeightHeight(wh1);

		System.out.println("sucesso : " + sucesso1);
//
//		WeightHeight wh2 = new WeightHeight();
//
//		wh2.setHeight(1.65);
//		wh2.setWeight(80.9);
//		boolean sucesso2 = daoWh.insertWeightHeight(wh2);
//
//		System.out.println("sucesso : " + sucesso2);
//
//		WeightHeight wh3 = new WeightHeight();
//
//		wh3.setHeight(1.85);
//		wh3.setWeight(93.9);
//		boolean sucesso3 = daoWh.insertWeightHeight(wh3);
//
//		System.out.println("sucesso : " + sucesso3);
//		
//		
//		WeightHeight wh4 = new WeightHeight();
//
//		wh4.setHeight(1.60);
//		wh4.setWeight(50.9);
//		boolean sucesso4 = daoWh.insertWeightHeight(wh4);
//
//		System.out.println("sucesso : " + sucesso4);
//
//		WeightHeight wh5 = new WeightHeight();
//
//		wh5.setHeight(1.70);
//		wh5.setWeight(52.0);
//		boolean sucesso5 = daoWh.insertWeightHeight(wh5);
//
//		System.out.println("sucesso : " + sucesso5);
		
		
		System.out.println(daoWh.getAll());
		
	}

}
