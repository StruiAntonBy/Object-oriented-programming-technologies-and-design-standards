import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CarOwner;
import storage.Storage;
 
@WebServlet("/index.html")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<CarOwner> objects = Storage.readAll();
		request.setAttribute("objects", objects);
		getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}