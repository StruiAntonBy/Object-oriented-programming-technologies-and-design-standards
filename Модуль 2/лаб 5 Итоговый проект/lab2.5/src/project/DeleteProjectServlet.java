package project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.Storage;

public class DeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("action").equals("Delete")) {
			try {
				Storage.deleteProject(Integer.parseInt(req.getParameter("id")));
			}
			catch(SQLException e) {
	            throw new ServletException(e);
	        }catch(NullPointerException e) {}
	        resp.sendRedirect(req.getContextPath() + "/index.html");
		}
		else {
			resp.sendRedirect(req.getContextPath() + "/editProject.html?id="+req.getParameter("id"));
		}
    }
	
}
