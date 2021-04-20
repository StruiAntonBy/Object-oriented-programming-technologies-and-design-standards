package user;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import storage.Storage;

public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
	        for(String id : req.getParameterValues("id")) {
	            try {
	                Storage.deleteUser(Integer.parseInt(id));
	            }
	            catch(NumberFormatException e) {}
	            catch(SQLException e) {
	                throw new ServletException(e);
	            }
	        }
		}
		catch(NullPointerException e) {}
        resp.sendRedirect(req.getContextPath() + "/listUsers.html");
    }
	
}
