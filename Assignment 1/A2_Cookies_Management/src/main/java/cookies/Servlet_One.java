package cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//After Submitting form user will be redirected here showing the name of user entered by them

public class Servlet_One extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set the response MIME
		response.setContentType("text/html");

		PrintWriter printWriter = response.getWriter();

		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>Https Stateless Problem</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");

		// Extract the data given by user
		String user_name = request.getParameter("name");

		try {
			// add cookie
			Cookie cookie = new Cookie("UserNameKey", user_name);
			response.addCookie(cookie);

			System.out.println("Cookie Saved Successfully");

		} catch (Exception e) {
			System.out.println("Trying to save invalid data into cookie");
			// e.printStackTrace();
		}

		printWriter.println("<h1>Welcome " + user_name + " To ServletOne </h1>");
		printWriter.println("<br>");
		printWriter.println("<h1><a href='ServletTwo'>Go To Servlet 2</a></h2>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}
}
