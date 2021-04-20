package requirement;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Requirement;
import storage.Storage;

public class EditRequirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			if(request.getParameter("id")!=null) {
				int id=Integer.parseInt(request.getParameter("id"));
				Requirement object=Storage.readRequirementById(id);
				request.setAttribute("object", object);
				request.setAttribute("ProjectId",object.getProjectId());
			}
			else {
				int ProjectId=Integer.parseInt(request.getParameter("ProjectId"));
				request.setAttribute("ProjectId",ProjectId);
			}
		}
		catch(NumberFormatException e) {}
    	catch(SQLException e) {
    		throw new ServletException(e);
    	}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit/editRequirement.jsp").forward(request, response);
	}
}
