import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CarOwner;
import storage.Storage;
 
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost/my_db?"
                                   + "useUnicode=true&"
                                   + "characterEncoding=UTF-8&"
                                   + "serverTimezone=Europe/Moscow";
    public static final String USER = "anton";
    public static final String PASSWORD = "anton07012001s";
    
    @Override
    public void init() throws ServletException {
        try {
            Storage.init(DRIVER, URL, USER, PASSWORD);
        } catch(ClassNotFoundException e) {
            throw new ServletException(e);
        }

    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			  Collection<CarOwner> objects = Storage.readAll();
			  request.setAttribute("objects", objects);
			  getServletContext().getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
		catch(SQLException e) {
            throw new ServletException(e);
        }
	}
}