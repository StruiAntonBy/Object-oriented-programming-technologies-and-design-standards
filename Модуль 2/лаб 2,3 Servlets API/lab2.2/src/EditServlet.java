import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CarOwner;
import storage.Storage;

@WebServlet("/edit.html")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	try {
    		Integer id = Integer.parseInt(req.getParameter("id"));
            CarOwner object = Storage.readById(id);
            req.setAttribute("object", object);
    	}catch(NumberFormatException e) {}
    	getServletContext().getRequestDispatcher("/WEB-INF/edit.jsp").forward(req, resp);
    }
}
