package browser_info;

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

		// Get the info of client browser
		String user_browser = request.getHeader("User-agent");

		printWriter.println("<h1>" + user_browser + "</h1>");
		printWriter.println("</body>");
		printWriter.println("</html>");
	}

}
