package requirement;


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

public class SaveRequirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Requirement object=new Requirement();
		if(req.getParameter("Description")!="" && req.getParameter("TimeImplementation")!="" && Integer.parseInt(req.getParameter("TimeImplementation"))>0
				&& req.getParameter("Priority")!=null && req.getParameter("ProbabilityOfChange")!=null) {
			object.setDescription(req.getParameter("Description"));
			object.setTimeImplementation(Integer.parseInt(req.getParameter("TimeImplementation")));
			try {
				object.setMarkOfImplementation(Boolean.parseBoolean(req.getParameter("MarkOfImplementation")));
			}catch(NumberFormatException e) {}
			object.setPriority(Integer.parseInt(req.getParameter("Priority")));
			object.setProbabilityOfChange(Integer.parseInt(req.getParameter("ProbabilityOfChange")));
			object.setProjectId(Integer.parseInt(req.getParameter("ProjectId")));
			try {
				if(req.getParameter("id")!="") {
					object.setId(Integer.parseInt(req.getParameter("id")));
					Storage.updateRequirement(object);
				}
				else {
					Storage.addRequirement(object);
				}
				Collection<Requirement> arr=Storage.getAllProjectRequirements(object.getProjectId());
				float persent=Project.calculatePercentProjectCompletion(arr);
				Project project=Storage.readProjectById(object.getProjectId());
				int needForProgrammers=project.calculateNeedForProgrammers(arr);
				project.setNeedForProgrammers(needForProgrammers);
				project.setPercentProjectCompletion(persent);
				Storage.updateProject(project);
			}catch(SQLException e) {
	            throw new ServletException(e);
	        }
	        resp.sendRedirect(req.getContextPath() + "/listRequirements.html?ProjectId="+Integer.parseInt(req.getParameter("ProjectId")));
		}
		else {
			getServletContext().getRequestDispatcher("/WEB-INF/jsp/error/errorSaveRequirement.jsp").forward(req, resp);
		}
    }
	
}
