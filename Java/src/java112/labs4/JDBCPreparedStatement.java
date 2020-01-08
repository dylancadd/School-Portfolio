package java112.labs4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     djcadd
 *
 */
public class JDBCPreparedStatement {

    public void runSample(String[] args) {

        try (
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/student", "student", "student");
            PreparedStatement updateEmployee = connection.prepareStatement("INSERT INTO employees(first_name, last_name, ssn, dept, room, phone) VALUES(?,?,?,?,?,?)");
            Statement statement = connection.createStatement();
        ) {
            Class.forName("com.mysql.cj.jdbc.Driver");

            updateEmployee.setString(1, args[0]);
            updateEmployee.setString(2, args[1]);
            updateEmployee.setString(3, args[2]);
            updateEmployee.setString(4, args[3]);
            updateEmployee.setString(5, args[4]);
            updateEmployee.setString(6, args[5]);

            updateEmployee.executeUpdate();

            String queryString = "SELECT * FROM employees ORDER BY emp_id DESC LIMIT 1";

            try (ResultSet resultSet = statement.executeQuery(queryString)) {
                while(resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String ssn = resultSet.getString("ssn");
                    String dept = resultSet.getString("dept");
                    String room = resultSet.getString("room");
                    String phone = resultSet.getString("phone");

                    System.out.println("Inserted data...");
                    System.out.println();
                    System.out.println("First Name: " + firstName);
                    System.out.println("Last Name: " + lastName);
                    System.out.println("SSN: " + ssn);
                    System.out.println("Dept: " + dept);
                    System.out.println("Room: " + room);
                    System.out.println("Phone: " + phone);
                }

            }

        }  catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    /**
     *  The main program for the JDBCPreparedStatement class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {

        JDBCPreparedStatement employees = new JDBCPreparedStatement();

        employees.runSample(args);

    }
}
