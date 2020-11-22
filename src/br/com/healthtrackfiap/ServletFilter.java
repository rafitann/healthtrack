package br.com.healthtrackfiap;

import java.io.File;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import br.com.healthtrackfiap.daos.ConfiguracaoBD;

/**
 * Servlet Filter implementation class ServletFilter
 */
@WebFilter("/*")
public class ServletFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ServletFilter() {}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
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
		
		if(!exists) {	
			ConfiguracaoBD.populate();
		}
		
		
	}

}
