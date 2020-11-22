package br.com.healthtrackfiap.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet({"/FoodServlet", "/food"})
public class FoodServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FoodServlet() {
    	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Servlet Food ").append(request.getContextPath());
        RequestDispatcher rd = request.getRequestDispatcher("Food.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
