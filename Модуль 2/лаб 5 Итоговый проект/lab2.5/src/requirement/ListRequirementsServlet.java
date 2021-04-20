package requirement;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Requirement;
import sort.RequirementComparator;
import storage.Storage;

public class ListRequirementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int ProjectId=Integer.parseInt(request.getParameter("ProjectId"));  
			ArrayList<Requirement> objects = Storage.getAllProjectRequirements(ProjectId);
			RequirementComparator c=new RequirementComparator();
			objects.sort(c);
			request.setAttribute("objects", objects);
			request.setAttribute("ProjectId", ProjectId);
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/list/listRequirements.jsp").forward(request, response);
		}
		catch(NumberFormatException e) {}
		catch(SQLException e) {
			throw new ServletException(e);
      }
	}
	
}
