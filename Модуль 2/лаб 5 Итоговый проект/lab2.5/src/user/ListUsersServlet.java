package user;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
import sort.UserComparator;
import storage.Storage;

public class ListUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  ArrayList<User> objects = Storage.readAllUsers();
			  UserComparator c = new UserComparator();
			  objects.sort(c.reversed());
			  request.setAttribute("objects", objects);
			  getServletContext().getRequestDispatcher("/WEB-INF/jsp/list/listUsers.jsp").forward(request, response);
		}
		catch(SQLException e) {
			throw new ServletException(e);
		}
	}
	
}
