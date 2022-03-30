package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

public class ServletTwo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean isDesiredValuePresent = false;
		String user_name = "";

		// set response type MIME
		response.setContentType("text/html");

		PrintWriter printWriter = response.getWriter();

		printWriter.println("<!DOCTYPE html");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>Https Stateless Problem</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");

		// Extract info from the cookie
		Cookie[] cookies = request.getCookies();

		// Here we got cookies if there is noting in the cookie null will be returned
		if (cookies == null) {
			isDesiredValuePresent = false;
			printWriter.println("<h2>You are new user so go to home page and submit your name first.</h2>");

			// Log
			System.out.println("Because Cookies[] is null");
			return;
		}

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("UserNameKey")) {
				user_name = cookie.getValue();
				isDesiredValuePresent = true;
				break;
			}
		}

		if (isDesiredValuePresent) {
			printWriter.println("<h1>Welcome " + user_name + " To ServletTwo </h1>");
			printWriter.println("<br>");
			printWriter.println("<h1>Thanks For Visiting</h2>");
		} else {
			printWriter.println("<h2>You are new user so go to home page and submit your name first.</h2>");

			// Log
			System.out.println("Because isDesiredValuePresent: " + isDesiredValuePresent);
		}
	}

}
