package br.com.healthtrackfiap.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrackfiap.controller.bean.WeightHeightBean;
import br.com.healthtrackfiap.daos.WeightHeightDAO;
import br.com.healthtrackfiap.exception.DataIncorretaException;
import br.com.healthtrackfiap.models.WeightHeight;
import br.com.healthtrackfiap.utils.FormatadorNumero;

public class ImcController {

	private WeightHeightDAO dao;

	public ImcController() {
		dao = new WeightHeightDAO();
	}

	public List<WeightHeight> getAll() {
//		List<WeightHeightBean> bean = new ArrayList<WeightHeightBean>();
//		List<WeightHeight> imcs = new ArrayList<WeightHeight>();
//
//		for (WeightHeight imc : imcs) {
//			WeightHeightBean b = new WeightHeightBean(imc.getIdImc(), imc.getHeight(), imc.getWeight(),
//					imc.getCreatedAt());
//
//			try {
//
//				double ind = imc.getWeight() / (imc.getHeight() * imc.getHeight());
//
//				b.setBmi(FormatadorNumero.toNumber(ind, 2));
//
//				if (ind < 18.5)
//					b.setBmiClassification("Abaixo do Peso");
//				else if (ind >= 18.5 && ind < 24.9)
//					b.setBmiClassification("Normal");
//				else if (ind >= 24.9 && ind < 29.9)
//					b.setBmiClassification("Sobrepeso");
//				else if (ind >= 29.9 && ind < 34.9)
//					b.setBmiClassification("Obesidade Grau 1");
//				else if (ind >= 34.9 && ind < 39.9)
//					b.setBmiClassification("Obesidade Grau 2");
//				else
//					b.setBmiClassification("Obesidade Grau 3");
//
//			} catch (DataIncorretaException e) {
//				e.printStackTrace();
//			}
//
//			bean.add(b);
//		}

		return dao.getAll();
	}

	public boolean saveOrUpdate(WeightHeight wh) {

//		WeightHeight wh = new WeightHeight();
//
//		wh.setHeight(Double.parseDouble(bean.getHeight()));
//		wh.setWeight(Double.parseDouble(bean.getWeight()));

		try {
			dao.insertWeightHeight(wh);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
