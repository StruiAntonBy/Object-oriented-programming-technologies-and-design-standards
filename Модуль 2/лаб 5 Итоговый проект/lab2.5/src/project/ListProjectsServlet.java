package project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.Project;
import data.User;
import storage.Storage;
import hash.Sha256;
import sort.ProjectComparator;

public class ListProjectsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DRIVER="com.mysql.cj.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost/company_db?"
            						+ "useUnicode=true&"
            						+ "characterEncoding=UTF-8&"
            						+ "serverTimezone=Europe/Moscow";
	private static final String USER="anton";
	private static final String PASSWORD="anton07012001s";
	
	@Override
    public void init() throws ServletException {
        try {
            Storage.init(DRIVER, URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) {
        	throw new ServletException(e);
        }

    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Login=request.getParameter("Login");
		String Password=request.getParameter("Password");
		Password=Sha256.getStringHash(Password);
		User user;
		try {
			user = Storage.readUser(Login, Password);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		if(user==null) {
			getServletContext().getRequestDispatcher("/WEB-INF/html/error/errorAuthorization.html").forward(request, response);
		}
		HttpSession session = request.getSession();
        session.setAttribute("user", user);
        doPostGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPostGet(request, response);
	}
	
	private void doPostGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  ArrayList<Project> objects = Storage.readAllProjects();
			  request.setAttribute("objects", objects);
			  ProjectComparator c=new ProjectComparator();
			  objects.sort(c);
			  getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
		catch(SQLException e) {
			throw new ServletException(e);
		}
	}
	
}
