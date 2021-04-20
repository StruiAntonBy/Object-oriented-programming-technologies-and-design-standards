package storage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import data.CarOwner;

public class Storage {
    private static String jdbcUrl = null;
    private static String jdbcUser = null;
    private static String jdbcPassword = null;

    public static void init(String jdbcDriver,String jdbcUrl,String jdbcUser,String jdbcPassword) throws ClassNotFoundException {
        Class.forName(jdbcDriver);
        Storage.jdbcUrl = jdbcUrl;
        Storage.jdbcUser = jdbcUser;
        Storage.jdbcPassword = jdbcPassword;
    }

    public static Collection<CarOwner> readAll() throws SQLException{
        String sql = "SELECT Id, CarNumber, Name, Surname, MiddlName, CompositionOffense, DateOffense, PenaltySum, DatePayment, Penalty "
                   + "FROM CarOwner";
        Connection c = null;
        Statement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.createStatement();
            r = s.executeQuery(sql);
            Collection<CarOwner> objects = new ArrayList<>();
            while(r.next()) {
                CarOwner object = new CarOwner();
                object.setId(r.getInt("id"));
                object.setCarNumber(r.getString("CarNumber"));
                object.setName(r.getString("Name"));
                object.setSurname(r.getString("Surname"));
                object.setMiddlName(r.getString("MiddlName"));
                object.setCompositionOffense(r.getString("CompositionOffense"));
                object.setDateOffense(r.getString("DateOffense"));
                object.setPenaltySum(r.getDouble("PenaltySum"));
                object.setDatePayment(r.getString("DatePayment"));
                object.setPenalty(r.getDouble("Penalty"));
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

    public static CarOwner readById(Integer id) throws SQLException {
        String sql = "SELECT CarNumber, Name, Surname, MiddlName, CompositionOffense, DateOffense, PenaltySum, DatePayment, Penalty "
                   + "FROM CarOwner "
                   + "WHERE Id = ?";
        Connection c = null;
        PreparedStatement s = null;
        ResultSet r = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            r = s.executeQuery();
            CarOwner object = null;
            if(r.next()) {
                object = new CarOwner();
                object.setId(id);
                object.setCarNumber(r.getString("CarNumber"));
                object.setName(r.getString("Name"));
                object.setSurname(r.getString("Surname"));
                object.setMiddlName(r.getString("MiddlName"));
                object.setCompositionOffense(r.getString("CompositionOffense"));
                object.setDateOffense(r.getString("DateOffense"));
                object.setPenaltySum(r.getDouble("PenaltySum"));
                object.setDatePayment(r.getString("DatePayment"));
                object.setPenalty(r.getDouble("Penalty"));
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

    public static void create(CarOwner object) throws SQLException {
        String sql = "INSERT INTO CarOwner "
                   + "(CarNumber, Name, Surname, MiddlName, CompositionOffense, DateOffense, PenaltySum, DatePayment, Penalty) "
                   + "VALUES "
                   + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getCarNumber());
            s.setString(2, object.getName());
            s.setString(3, object.getSurname());
            s.setString(4, object.getMiddlName());
            s.setString(5, object.getCompositionOffense());
            s.setString(6, object.getDateOffense());
            s.setDouble(7, object.getPenaltySum());
            s.setString(8,object.getDatePayment());
            s.setDouble(9, object.getPenalty());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void update(CarOwner object) throws SQLException {
        String sql = "UPDATE CarOwner SET "
                   + "CarNumber=?, Name=?, Surname=?, MiddlName=?, CompositionOffense=?, DateOffense=?, PenaltySum=?, DatePayment=?, Penalty=? "
                   + "WHERE Id = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setString(1, object.getCarNumber());
            s.setString(2, object.getName());
            s.setString(3, object.getSurname());
            s.setString(4, object.getMiddlName());
            s.setString(5, object.getCompositionOffense());
            s.setString(6, object.getDateOffense());
            s.setDouble(7, object.getPenaltySum());
            s.setString(8,object.getDatePayment());
            s.setDouble(9, object.getPenalty());
            s.setInt(10, object.getId());
            s.executeUpdate();
        } finally {
            try {
                s.close();
            } catch(NullPointerException | SQLException e) {}
            try {
                c.close();
            } catch(NullPointerException | SQLException e) {}
        }
    }

    public static void delete(Integer id) throws SQLException {
        String sql = "DELETE FROM CarOwner "
                   + "WHERE Id = ?";
        Connection c = null;
        PreparedStatement s = null;
        try {
            c = getConnection();
            s = c.prepareStatement(sql);
            s.setInt(1, id);
            s.executeUpdate();
        } finally {
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