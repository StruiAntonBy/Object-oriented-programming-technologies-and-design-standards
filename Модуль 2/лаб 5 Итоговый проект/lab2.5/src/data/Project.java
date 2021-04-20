package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Collection;

public class Project {
	private int Id;
	private String NameProject;
	private String NameClient;
	private String StartDate;
	private String EndDate;
	private float PercentProjectCompletion;
	private int NeedForProgrammers;
	private static final DateTimeFormatter Formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	public int calculateNeedForProgrammers(Collection <Requirement> objects) {
		double sum=0;
		for(Requirement object : objects) {
			if(!object.isMarkOfImplementation()) {
				sum=sum+object.getTimeImplementation();
			}
		}
		LocalDate startDate = LocalDate.now();
		LocalDate endDate=LocalDate.parse(EndDate, Formatter);
		if(startDate.getYear()>=endDate.getYear() & startDate.getMonthValue()>=endDate.getMonthValue() & startDate.getDayOfMonth()>=endDate.getDayOfMonth()) {
			return 0;
		}
		double sumWorkingHours=0;
		while(startDate.getYear()!=endDate.getYear() | startDate.getMonthValue()!=endDate.getMonthValue() | startDate.getDayOfMonth()!=endDate.getDayOfMonth()) {
			if(startDate.getDayOfWeek().get(ChronoField.DAY_OF_WEEK)<6) {
				sumWorkingHours+=8;
			}
			startDate=startDate.plusDays(1);
		}
		if(sum==0 | sumWorkingHours==0) {
			return 0;
		}
		else if(sumWorkingHours>sum) {
			return 1;
		}
		else {
			return (int)Math.ceil(sum/sumWorkingHours);
		}
	}
	
	public static float calculatePercentProjectCompletion(Collection <Requirement> objects) {
		float sum=0;
		float number=0;
		for(Requirement object : objects) {
			sum=sum+object.getTimeImplementation();
			if(object.isMarkOfImplementation()) {
				number=number+object.getTimeImplementation();
			}
		}
		if(sum==0) {
			return 1;
		}
		return number/sum;
	}
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}

	public String getNameProject() {
		return NameProject;
	}

	public void setNameProject(String nameProject) {
		NameProject = nameProject;
	}

	public String getNameClient() {
		return NameClient;
	}

	public void setNameClient(String nameClient) {
		NameClient = nameClient;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public float getPercentProjectCompletion() {
		return PercentProjectCompletion;
	}

	public void setPercentProjectCompletion(float percentProjectCompletion) {
		PercentProjectCompletion = percentProjectCompletion;
	}

	public int getNeedForProgrammers() {
		return NeedForProgrammers;
	}

	public void setNeedForProgrammers(int needForProgrammers) {
		NeedForProgrammers = needForProgrammers;
	}
	
}
