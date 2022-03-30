package max;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter printWriter = response.getWriter();

		printWriter.println("<!DOCTYPE html>");
		printWriter.println("<html lang='en'>");
		printWriter.println("<head>");
		printWriter.println("<title>Max of 2 Numbers</title>");
		printWriter.println("</head>");
		printWriter.println("<body>");

		// Extract 2 numbers given by user
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");

		String heading = "";
		if (Integer.parseInt(num1) > Integer.parseInt(num2))
			heading = num1 + " is Greater than " + num2;
		else
			heading = num2 + " is Greater than " + num1;

		printWriter.println("<h1>" + heading + "</h1>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

}
