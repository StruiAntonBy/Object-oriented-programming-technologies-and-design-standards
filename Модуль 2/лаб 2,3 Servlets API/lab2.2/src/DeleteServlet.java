import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.Storage;

@WebServlet("/delete.html")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                                    throws ServletException, IOException {
		try {
	        for(String id : req.getParameterValues("id")) {
	            try {
	                Storage.delete(Integer.parseInt(id));
	            } catch(NumberFormatException e) {}
	        }
		}
		catch(NullPointerException e) {}
        resp.sendRedirect(req.getContextPath() + "/index.html");
    }
}
