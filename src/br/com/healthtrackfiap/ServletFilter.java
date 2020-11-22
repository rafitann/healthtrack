package br.com.healthtrackfiap;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.healthtrackfiap.daos.ConfiguracaoBD;
import br.com.healthtrackfiap.models.User;

/**
 * Servlet Filter implementation class ServletFilter
 */
@WebFilter("/*")
public class ServletFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public ServletFilter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("user"));
		User user = (User) session.getAttribute("user");

		boolean authorize = false;
		
		String path = req.getServletPath();
		if (path.startsWith("/css") || path.startsWith("/js") || path.startsWith("/assets")) {
			authorize = true;
			
		} else if (user == null) {
			if (!path.equalsIgnoreCase("/login")) {
				authorize = false;	
			} else if (path.equalsIgnoreCase("/login")) {
				authorize = true;	
			}
			
		} else {
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("auth")) {
						authorize = user.getUserID().equals(cookie.getValue());
						break;
					}
				}
			} else
				authorize = false;
		}

		if (authorize)
			chain.doFilter(request, response);

		else {
			RequestDispatcher rd = request.getRequestDispatcher("login");
			rd.forward(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		File f = new File(config.getServletContext().getRealPath("/"), "healthTrackFIAP.db");
		System.out.println(f.getAbsolutePath());

		Boolean exists = f.exists();

		ConfiguracaoBD.load(f);
		ConfiguracaoBD.createDatabase();

		if (!exists) {
			ConfiguracaoBD.populate();
		}

	}

}
