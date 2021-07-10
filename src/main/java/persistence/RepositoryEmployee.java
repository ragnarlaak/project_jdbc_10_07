package persistence;

import model.Employee;
import util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RepositoryEmployee {

    private Connection connection;
    private PreparedStatement pst;

    public RepositoryEmployee() {
        connection = DBUtil.getDBConnection();
    }

    public void saveEmployee(Employee employee) {
        String sql = "INSERT INTO employees (firstName," +
                " lastname, dateOfBirth, email, phoneNumber," +
                " salary ) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, employee.getFirstName());
            pst.setString(2, employee.getLastName());
            pst.setDate(3, Date.valueOf(employee.getDateOfBirth()));
            pst.setString(4, employee.getEmail());
            pst.setString(5, employee.getPhoneNumber());
            pst.setInt(6, employee.getSalary());

            int result = pst.executeUpdate();

            if (result > 0){
                System.out.println("Employee saved successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET salary = ? WHERE employeeId = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, employee.getSalary());
            pst.setInt(2, employee.getEmployeeId());

            int result = pst.executeUpdate();
            if (result > 0){
                System.out.println("Employee updated successfully");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee) {
        String sql = "DELETE FROM employees WHERE employeeId = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, employee.getEmployeeId());
            int result = pst.executeUpdate();

            if (result > 0) {
                System.out.println("Employee deleted successfully");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Employee findEmployeeById(int employeeId) {
        return null;
    }

    public List<Employee> listAllEmployees() {
        return null;
    }

    public List<Employee> listAllEmployeesByDepartment(int departmentId){
        return null;
    }
}
