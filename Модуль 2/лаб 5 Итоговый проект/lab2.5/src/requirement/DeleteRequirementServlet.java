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

public class DeleteRequirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
	        for(String id : req.getParameterValues("id")) {
	            try {
	                Storage.deleteRequirement(Integer.parseInt(id));
	                
	            }
	            catch(NumberFormatException e) {}
	            catch(SQLException e) {
	                throw new ServletException(e);
	            }
	        }
		}
		catch(NullPointerException e) {}
		try {
			Collection<Requirement> arr=Storage.getAllProjectRequirements(Integer.parseInt(req.getParameter("ProjectId")));
			float persent=Project.calculatePercentProjectCompletion(arr);
			Project project=Storage.readProjectById(Integer.parseInt(req.getParameter("ProjectId")));
			int needForProgrammers=project.calculateNeedForProgrammers(arr);
			project.setNeedForProgrammers(needForProgrammers);
			project.setPercentProjectCompletion(persent);
			Storage.updateProject(project);
		}catch(SQLException e) {
            throw new ServletException(e);
        }
        resp.sendRedirect(req.getContextPath() + "/listRequirements.html?ProjectId="+Integer.parseInt(req.getParameter("ProjectId")));
    }
	
}
