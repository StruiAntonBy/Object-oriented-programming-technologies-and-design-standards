package data;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

public final class CarOwner implements CarOwnerInterface,Serializable{
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String CarNumber;
	private String Name;
	private String Surname;
	private String MiddlName;
	private String CompositionOffense;
	private String DateOffense;
	private double PenaltySum;
	private String DatePayment;
	private double Penalty;
	private static final float Percent=0.01f;
	
	public String getCarNumber() {
		return CarNumber;
	}
	public void setCarNumber(String carNumber) {
		CarNumber = carNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getMiddlName() {
		return MiddlName;
	}
	public void setMiddlName(String middlName) {
		MiddlName = middlName;
	}
	public String getCompositionOffense() {
		return CompositionOffense;
	}
	public void setCompositionOffense(String compositionOffense) {
		CompositionOffense = compositionOffense;
	}
	public String getDateOffense() {
		return DateOffense;
	}
	public void setDateOffense(String dateOffense) {
		DateOffense = dateOffense;
	}
	public double getPenaltySum() {
		return PenaltySum;
	}
	public void setPenaltySum(double penaltySum) {
		PenaltySum = penaltySum;
	}
	public String getDatePayment() {
		return DatePayment;
	}
	public void setDatePayment(String datePayment) {
		DatePayment = datePayment;
	}
	public void CalculatingPenalty() {
		LocalDate startDate = LocalDate.parse(DateOffense, Constant.formatter);
		LocalDate endDate;
		if(DatePayment==null) {
			endDate = LocalDate.now();
		}
		else {
			endDate = LocalDate.parse(DatePayment, Constant.formatter);
		}
		Period period = Period.between(startDate, endDate);
		int allDays=(period.getYears()*360)+(period.getMonths()*30)+period.getDays();
		if(allDays>30) {
			Penalty=PenaltySum*Percent*(allDays-30);
		}
		else {
			Penalty=0;
		}
	}
	public static boolean isValidDate(String dateString) {
	    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    try {
	        df.parse(dateString);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
	public double getPenalty() {
		return Penalty;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
}