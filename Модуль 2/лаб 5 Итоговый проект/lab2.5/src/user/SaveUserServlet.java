package user;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.User;
import hash.Sha256;
import storage.Storage;

public class SaveUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		User object=new User();
		if(req.getParameter("Login")!="" && req.getParameter("Password")!="" && req.getParameter("Role")!=null
				&& req.getParameter("Login").length()<=20) {
			object.setLogin(req.getParameter("Login"));
			object.setPassword(Sha256.getStringHash(req.getParameter("Password")));
			object.setRole(Integer.parseInt(req.getParameter("Role")));
			if(req.getParameter("id")!="") {
				object.setId(Integer.parseInt(req.getParameter("id")));
				try {
					if(!Storage.updateUser(object)) {
						getServletContext().getRequestDispatcher("/WEB-INF/html/error/errorIdenticalUser.html").forward(req, resp);
					}
				}catch(SQLException e) {
		            throw new ServletException(e);
		        }
			}
			else {
				try {
					if(!Storage.addUser(object)) {
						getServletContext().getRequestDispatcher("/WEB-INF/html/error/errorIdenticalUser.html").forward(req, resp);
					}
				}catch(SQLException e) {
		            throw new ServletException(e);
		        }
			}
	        resp.sendRedirect(req.getContextPath() + "/listUsers.html");
		}
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/html/error/errorSaveUser.html").forward(req, resp);
		}
    }
	
}
