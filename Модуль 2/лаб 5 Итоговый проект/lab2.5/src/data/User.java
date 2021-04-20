package data;

public class User {
	private int Id;
	private String Login;
	private String Password;
	private int Role;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getRole() {
		return Role;
	}

	public void setRole(int role) {
		Role = role;
	}
	
}
