package br.com.healthtrackfiap.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.healthtrackfiap.controller.ImcController;
import br.com.healthtrackfiap.controller.bean.WeightHeightBean;
import br.com.healthtrackfiap.models.WeightHeight;

/**
 * Servlet implementation class BMIServlet
 */
@WebServlet({ "/ImcServlet", "/imc" })
public class BMIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BMIServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<WeightHeight> imcs = new ImcController().getAll();
		request.setAttribute("imcs", imcs);

		RequestDispatcher rd = request.getRequestDispatcher("imc.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ImcController controller = new ImcController();

//		WeightHeightBean bean = new WeightHeightBean();
//		bean.setHeight(request.getParameter("height"));
//		bean.setWeight(request.getParameter("weight"));

		WeightHeight wh = new WeightHeight();
		wh.setHeight(Double.parseDouble(request.getParameter("height")));
		wh.setWeight(Double.parseDouble(request.getParameter("weight")));

		controller.saveOrUpdate(wh);
		doGet(request, response);
	}

}
