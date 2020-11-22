package br.com.healthtrackfiap.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrackfiap.daos.LoginDAO;
import br.com.healthtrackfiap.models.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({ "/LoginServlet", "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");

		for (Cookie cookie : request.getCookies()) {
			if (!"JSESSIONID".equals(cookie.getName())) {
				cookie.setMaxAge(0);
				cookie.setValue(null);
				response.addCookie(cookie);
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String pass = request.getParameter("password");

		User u = new LoginDAO().getUser(user, pass);

		RequestDispatcher rd = null;

		if (u != null) {
			Cookie cookie = new Cookie("auth", u.getUserID());
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 1); // 1 dia
			response.addCookie(cookie);

			request.getSession().setAttribute("user", u);

			response.sendRedirect(request.getContextPath() + "/home");
		} else
//			rd = request.getRequestDispatcher("/login");
//			rd.forward(request, response);
			doGet(request, response);

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		session.removeAttribute("user");

		for (Cookie cookie : request.getCookies()) {
			cookie.setMaxAge(0);
			cookie.setValue(null);
			response.addCookie(cookie);
		}

		doGet(request, response);
	}
}
