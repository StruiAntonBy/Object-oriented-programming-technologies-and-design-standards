package project;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Project;
import storage.Storage;

public class EditProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPostGet(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPostGet(request, response);
	}
	
	private void doPostGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			Project object=Storage.readProjectById(id);
			request.setAttribute("object", object);
		}
		catch(NumberFormatException e) {}
    	catch(SQLException e) {
    		throw new ServletException(e);
    	}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit/editProject.jsp").forward(request, response);
	}
}
