package project;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.Project;
import data.Requirement;
import storage.Storage;

public class SaveProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Project object=new Project();
		if(req.getParameter("NameProject")!="" && req.getParameter("NameClient")!="" && req.getParameter("StartDate")!="" && req.getParameter("EndDate")!=""
				&& req.getParameter("NameProject").length()<=20 && req.getParameter("NameClient").length()<=20) {
			object.setNameProject(req.getParameter("NameProject"));
			object.setNameClient(req.getParameter("NameClient"));
			object.setStartDate(req.getParameter("StartDate"));
			object.setEndDate(req.getParameter("EndDate"));
			try {
				if(req.getParameter("id")!="") {
					object.setId(Integer.parseInt(req.getParameter("id")));
					Collection<Requirement> arr=Storage.getAllProjectRequirements(object.getId());
					float percent=Project.calculatePercentProjectCompletion(arr);
					int needForProgrammers=object.calculateNeedForProgrammers(arr);
					object.setNeedForProgrammers(needForProgrammers);
					object.setPercentProjectCompletion(percent);
					Storage.updateProject(object);
				}
				else {
					Storage.addProject(object);
				}
			}catch(SQLException e) {
	            throw new ServletException(e);
	        }
	        resp.sendRedirect(req.getContextPath() + "/index.html");
		}
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error/errorSaveProject.jsp").forward(req, resp);
		}
    }
	
}
