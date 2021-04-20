package task2;

public class InfBookIssuance {
	
	private String BookName;
	private String LastNameReaderAndInitials;
	private String BookAuthor;
	private String DateIssueBook;
	private String DateReturnedBook;
	
	public InfBookIssuance(String LastNameReaderAndInitials,String BookName,String BookAuthor,String DateIssueBook,String DateReturnedBook) {
		this.LastNameReaderAndInitials=LastNameReaderAndInitials;
		this.BookName=BookName;
		this.BookAuthor=BookAuthor;
		this.DateIssueBook=DateIssueBook;
		this.DateReturnedBook=DateReturnedBook;
	}
	
	public InfBookIssuance() {
		this.LastNameReaderAndInitials=null;
		this.BookName=null;
		this.BookAuthor=null;
		this.DateIssueBook=null;
		this.DateReturnedBook=null;
	}
	
	@Override
	public String toString() {
		return LastNameReaderAndInitials+";"+BookName+";"+BookAuthor+";"+DateIssueBook+";"+DateReturnedBook;
	}
	
	public void setBookName(String BookName) {
		this.BookName=BookName;
	}
	
	public void setLastNameReaderAndInitials(String LastNameReaderAndInitials) {
		this.LastNameReaderAndInitials=LastNameReaderAndInitials;
	}
	
	public void setBookAuthor(String BookAuthor) {
		this.BookAuthor=BookAuthor;
	}
	
	public void setDateIssueBook(String DateIssueBook) {
		this.DateIssueBook=DateIssueBook;
	}
	
	public void setDateReturnedBook(String DateReturnedBook) {
		this.DateReturnedBook=DateReturnedBook;
	}
	
	public String getBookName() {
		return BookName;
	}
	
	public String getLastNameReaderAndInitials() {
		return LastNameReaderAndInitials;
	}
	
	public String getBookAuthor() {
		return BookAuthor;
	}
	
	public String getDateIssueBook() {
		return DateIssueBook;
	}
	
	public String getDateReturnedBook() {
		return DateReturnedBook;
	}
}
