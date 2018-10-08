package pl.coderslab.utils.DAO;

import pl.coderslab.utils.DbUtil;
import pl.coderslab.utils.models.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {

private static EmployeeDao instance;

public static EmployeeDao getInstance(){

    if(instance==null){
        instance= new EmployeeDao();
    }
    return instance;


    }
    private EmployeeDao(){

    }
    public boolean save(Employee employee){

    try (Connection connection = DbUtil.getConn()){
        try (PreparedStatement statement= connection.prepareStatement(
                "INSERT INTO Employees(name, lastname, address, phone, note, pph) VALUES (?, ?, ?, ?, ?, ?)")){
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getLastname());
            statement.setString(3, employee.getAddress());
            statement.setString(4, employee.getPhone());
            statement.setString(5, employee.getNote());
            statement.setDouble(6, employee.getPph());

            statement.executeUpdate();
            return true;

        }
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
    }

    public Employee getEmployeeById(int id){
        try ( Connection conn = DbUtil.getConn();
              PreparedStatement statement = conn.prepareStatement
                      ("SELECT *  FROM Employees WHERE id=?")){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Integer employeeId = rs.getInt("id");
                String name = rs.getString("name");
                String lastname = rs.getString("surname");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String note = rs.getString("note");
                double pph = rs.getDouble("pph");

                return new Employee(employeeId, name, lastname, address, phone, note, pph);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(Employee employee) {

        try (Connection connection = DbUtil.getConn()) {
            try (PreparedStatement statement = connection.prepareStatement(
                    "UPDATE Employees SET name=?, lastname=?, address=?, phone=?, note=?, pph=? WHERE id = ?")) {

                statement.setString(1, employee.getName());
                statement.setString(2, employee.getLastname());
                statement.setString(3, employee.getAddress());
                statement.setString(4, employee.getPhone());
                statement.setString(5, employee.getNote());
                statement.setDouble(6, employee.getPph());

                statement.executeUpdate();
                return true;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
    public boolean delete(int id){
        try(Connection conn = DbUtil.getConn();
            PreparedStatement statement = conn.prepareStatement
                    ("DELETE FROM Employees WHERE id=?")) {
            statement.setInt(1,id);
            int numRowsAffected = statement.executeUpdate();
            return numRowsAffected>0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
