package life_cycle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import jakarta.servlet.*;

public class PhaseOne implements Servlet {

	ServletConfig config;

	// --------------------------- Life Cycle Methods
	// ----------------------------------

	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		System.out.println("Creating Object....");
	}

	@Override
	public void service(ServletRequest request, ServletResponse respone) throws ServletException, IOException {
		System.out.println("Servicing...");

		// set content type
		respone.setContentType("text/html");

		PrintWriter out = respone.getWriter();
		out.println("<h1> Phase One (Using implement Servlet) </h1>");
		out.println("<h3> Todays Date and Time is :: " + new Date().toString() + " </h3>");
	}

	@Override
	public void destroy() {
		System.out.println("Destroying the servelet...");
	}

	// ------------------------------ Nonlife Cycle Methods
	// ----------------------------------

	@Override
	public ServletConfig getServletConfig() {
		return this.config;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Servelet is created by Anand Dasani";
	}

}

/*
 * This is First Metod wich implements Servlet Class in which the 5 methods has
 * to be overrided compulsory beacuse there is no body predefined
 * 
 * in Phase 2 (second mehtod) we will extend the generic servlet which has
 * already implemented the body of 4 mehtods except service method
 */
