package storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Project;
import data.Requirement;
import data.User;

public class Storage{
	private static String jdbcUrl = null;
	private static String jdbcUser = null;
	private static String jdbcPassword = null;
	
	public static void init(String jdbcDriver,String jdbcUrl,String jdbcUser,String jdbcPassword) throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        Storage.jdbcUrl = jdbcUrl;
        Storage.jdbcUser = jdbcUser;
        Storage.jdbcPassword = jdbcPassword;
    }
	
	public static boolean updateUser(User obj) throws SQLException {
		String sql="UPDATE Users SET Login=?, Password=?, Role=? WHERE Id=?";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, obj.getLogin());
			s.setString(2, obj.getPassword());
			s.setInt(3,obj.getRole());
			s.setInt(4, obj.getId());
			try {
				s.executeUpdate();
				return true;
			}catch(SQLIntegrityConstraintViolationException e){
				return false;
			}
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static User readUserById(int id) throws SQLException {
		String sql="SELECT Login, Password, Role FROM Users WHERE Id=?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, id);
			r = s.executeQuery();
			User object=null;
			if(r.next()) {
				object=new User();
				object.setId(id);
				object.setLogin(r.getString("Login"));
				object.setPassword(r.getString("Password"));
				object.setRole(r.getInt("Role"));
			}
			return object;
		}
		finally {
			try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static User readUser(String Login,String Password) throws SQLException {
		String sql="SELECT Id, Role FROM Users WHERE Login=? AND Password=?";
		Connection c = null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, Login);
			s.setString(2, Password);
			r = s.executeQuery();
			User object=null;
			if(r.next()) {
				object=new User();
				object.setId(r.getInt("Id"));
				object.setLogin(Login);
				object.setPassword(Password);
				object.setRole(r.getInt("Role"));
			}
			return object;
		}
		finally {
			try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static boolean addUser(User obj) throws SQLException{
		String sql = "INSERT INTO Users(Login, Password, Role) VALUES(?, ?, ?)";
		Connection c = null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, obj.getLogin());
			s.setString(2, obj.getPassword());
			s.setInt(3,obj.getRole());
			try {
				s.executeUpdate();
				return true;
			}catch(SQLIntegrityConstraintViolationException e){
				return false;
			}
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static void deleteUser(int Id) throws SQLException {
		String sql = "DELETE FROM Users WHERE Id = ?";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, Id);
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static void deleteProject(int Id) throws SQLException {
		String sql = "DELETE FROM Projects WHERE Id = ?";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, Id);
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static void addProject(Project obj) throws SQLException{
		String sql = "INSERT INTO Projects"+
				"(NameProject, NameClient, StartDate, EndDate) "+
				"VALUES(?, ?, ?, ?)";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, obj.getNameProject());
			s.setString(2, obj.getNameClient());
			s.setString(3, obj.getStartDate());
			s.setString(4, obj.getEndDate());
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static void updateProject(Project obj) throws SQLException{
		String sql = "UPDATE Projects SET "+
				"NameProject=?, NameClient=?, StartDate=?, EndDate=?, PercentProjectCompletion=?, NeedForProgrammers=? "+
				"WHERE Id=?";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, obj.getNameProject());
			s.setString(2, obj.getNameClient());
			s.setString(3, obj.getStartDate());
			s.setString(4, obj.getEndDate());
			s.setFloat(5, obj.getPercentProjectCompletion());
			s.setInt(6, obj.getNeedForProgrammers());
			s.setInt(7, obj.getId());
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static Project readProjectById(int Id) throws SQLException{
		String sql = "SELECT NameProject, NameClient, StartDate, EndDate, PercentProjectCompletion, NeedForProgrammers "
				+"FROM Projects WHERE Id=?";
		Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, Id);
            r = s.executeQuery();
            Project object=null;
            if(r.next()) {
                object = new Project();
                object.setId(Id);
                object.setNameProject(r.getString("NameProject"));
                object.setNameClient(r.getString("NameClient"));
                object.setStartDate(r.getString("StartDate"));
                object.setEndDate(r.getString("EndDate"));
                object.setPercentProjectCompletion(r.getFloat("PercentProjectCompletion"));
                object.setNeedForProgrammers(r.getInt("NeedForProgrammers"));
            }
            return object;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
	}
	
	public static ArrayList<Project> readAllProjects() throws SQLException{
		String sql = "SELECT Id, NameProject, NameClient, StartDate, EndDate, PercentProjectCompletion, NeedForProgrammers "
				+"FROM Projects";
		Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            ArrayList<Project> objects = new ArrayList<>();
            while(r.next()) {
                Project object = new Project();
                object.setId(r.getInt("Id"));
                object.setNameProject(r.getString("NameProject"));
                object.setNameClient(r.getString("NameClient"));
                object.setStartDate(r.getString("StartDate"));
                object.setEndDate(r.getString("EndDate"));
                object.setPercentProjectCompletion(r.getFloat("PercentProjectCompletion"));
                object.setNeedForProgrammers(r.getInt("NeedForProgrammers"));
                objects.add(object);
            }
            return objects;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
	}
	
	public static Requirement readRequirementById(int Id) throws SQLException{
		String sql="SELECT ProjectId, Description, TimeImplementation, MarkOfImplementation, Priority, ProbabilityOfChange "+
				"FROM Requirements WHERE Id=?";
		Connection c= null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, Id);
            r = s.executeQuery();
            Requirement object=null;
            if(r.next()) {
            	object = new Requirement();
                object.setId(Id);
                object.setProjectId(r.getInt("ProjectId"));
                object.setDescription(r.getString("Description"));
                object.setTimeImplementation(r.getInt("TimeImplementation"));
                object.setMarkOfImplementation(r.getBoolean("MarkOfImplementation"));
                object.setPriority(r.getInt("Priority"));
                object.setProbabilityOfChange(r.getInt("ProbabilityOfChange"));
            }
            return object;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
	}
	
	public static ArrayList<Requirement> getAllProjectRequirements(int ProjectId) throws SQLException{
		String sql="SELECT Id, Description, TimeImplementation, MarkOfImplementation, Priority, ProbabilityOfChange "+
				"FROM Requirements WHERE ProjectId=?";
		Connection c= null;
		PreparedStatement s = null;
		ResultSet r = null;
		try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, ProjectId);
            r = s.executeQuery();
            ArrayList<Requirement> objects = new ArrayList<>();
            while(r.next()) {
            	Requirement object = new Requirement();
                object.setId(r.getInt("Id"));
                object.setDescription(r.getString("Description"));
                object.setTimeImplementation(r.getInt("TimeImplementation"));
                object.setMarkOfImplementation(r.getBoolean("MarkOfImplementation"));
                object.setPriority(r.getInt("Priority"));
                object.setProbabilityOfChange(r.getInt("ProbabilityOfChange"));
                object.setProjectId(ProjectId);
                objects.add(object);
            }
            return objects;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
	}
	
	public static ArrayList<User> readAllUsers() throws SQLException{
		String sql="SELECT Id, Login, Password, Role FROM Users";
		Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            ArrayList<User> objects = new ArrayList<>();
            while(r.next()) {
                User object = new User();
                object.setId(r.getInt("Id"));
                object.setLogin(r.getString("Login"));
                object.setPassword(r.getString("Password"));
                object.setRole(r.getInt("Role"));
                objects.add(object);
            }
            return objects;
        } finally {
            try {
                r.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
	}
	
	public static void deleteRequirement(int Id) throws SQLException{
		String sql="DELETE FROM Requirements WHERE Id=?";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, Id);
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static void addRequirement(Requirement obj) throws SQLException{
		String sql="INSERT INTO Requirements"+
				"(ProjectId, Description, TimeImplementation, MarkOfImplementation, Priority, ProbabilityOfChange) "+
				"VALUES(?, ?, ?, ?, ?, ?)";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setInt(1, obj.getProjectId());
			s.setString(2, obj.getDescription());
			s.setInt(3, obj.getTimeImplementation());
			s.setBoolean(4, obj.isMarkOfImplementation());
			s.setInt(5, obj.getPriority());
			s.setInt(6, obj.getProbabilityOfChange());
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	public static void updateRequirement(Requirement obj) throws SQLException{
		String sql="UPDATE Requirements SET "+
				"Description=?, TimeImplementation=?, MarkOfImplementation=?, Priority=?, ProbabilityOfChange=? "+
				"WHERE Id=?";
		Connection c= null;
		PreparedStatement s = null;
		try {
			c = getConnection();
			s = c.prepareStatement(sql);
			s.setString(1, obj.getDescription());
			s.setInt(2, obj.getTimeImplementation());
			s.setBoolean(3, obj.isMarkOfImplementation());
			s.setInt(4, obj.getPriority());
			s.setInt(5, obj.getProbabilityOfChange());
			s.setInt(6, obj.getId());
			s.executeUpdate();
		}
		finally {
			try {
				s.close();
			} catch(NullPointerException | SQLException e) {}
	        try {
	        	c.close();
	        } catch(NullPointerException | SQLException e) {}
		}
	}
	
	private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jdbcUrl,jdbcUser,jdbcPassword);
    }
}
