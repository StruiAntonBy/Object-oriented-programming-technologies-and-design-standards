package user;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
import storage.Storage;

public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		try {
			int id=Integer.parseInt(request.getParameter("id"));
			User object=Storage.readUserById(id);
			request.setAttribute("object", object);
		}
		catch(NumberFormatException e) {}
    	catch(SQLException e) {
    		throw new ServletException(e);
    	}
		getServletContext().getRequestDispatcher("/WEB-INF/jsp/edit/editUser.jsp").forward(request, response);
	}
}
