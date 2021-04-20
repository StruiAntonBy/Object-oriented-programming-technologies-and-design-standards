import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CarOwner;
import storage.Storage;

@WebServlet("/save.html")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	                                    throws ServletException, IOException {
	        req.setCharacterEncoding("UTF-8");
	        CarOwner obj=new CarOwner();
	        if(req.getParameter("CarNumber")!="" &&  req.getParameter("Name")!="" && req.getParameter("MiddlName")!=""
	        		&& req.getParameter("Surname")!="" && req.getParameter("CompositionOffense")!="" 
	        		&& req.getParameter("PenaltySum")!="" && CarOwner.isValidDate(req.getParameter("DateOffense"))
	        		&& Double.parseDouble(req.getParameter("PenaltySum"))>0) {
		        obj.setCarNumber(req.getParameter("CarNumber"));
		        obj.setName(req.getParameter("Name"));
		        obj.setMiddlName(req.getParameter("MiddlName"));
		        obj.setSurname(req.getParameter("Surname"));
		        obj.setCompositionOffense(req.getParameter("CompositionOffense"));
		        obj.setPenaltySum(Double.parseDouble(req.getParameter("PenaltySum")));
		        obj.setDateOffense(req.getParameter("DateOffense"));
		        if(CarOwner.isValidDate(req.getParameter("DatePayment"))) {
		        	obj.setDatePayment(req.getParameter("DatePayment"));
		        }
		        obj.CalculatingPenalty();
		        try {
		            obj.setId(Integer.parseInt(req.getParameter("id")));
		        } catch(NumberFormatException e) {}
		        if(obj.getId() == null) {
		            Storage.create(obj);
		        } else {
		            Storage.update(obj);
		        }

		        resp.sendRedirect(req.getContextPath() + "/index.html");
	        }
	        else {
	        	getServletContext().getRequestDispatcher("/WEB-INF/error.html").forward(req, resp);
	        }
	    }
}
