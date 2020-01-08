package java112.labs4;

import java.io.*;
import java.sql.*;

/**
 *
 *@author     djcadd
 *
 */
public class JDBCInsertEmployee {

    public void runSample(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/student", "student", "student");

            statement = connection.createStatement();

            String firstNameArg = args[0];
            String lastNameArg = args[1];
            String snnArg = args[2];
            String deptArg = args[3];
            String roomArg = args[4];
            String phoneArg = args[5];

            String queryString = "INSERT INTO employees(first_name, last_name, ssn, dept, room, phone) VALUES"
                    + "('" + firstNameArg
                    + "', '" + lastNameArg
                    + "', '" + snnArg
                    + "', '" + deptArg
                    + "', '" + roomArg
                    + "', '" + phoneArg + "')";

            System.out.println("queryString: " + queryString);

            statement.executeUpdate(queryString);

            grabRecentInsert(lastNameArg);


        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }

                if (statement != null) {
                    statement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }

        public void grabRecentInsert(String arg) {

            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost/student", "student", "student");

                statement = connection.createStatement();

                String name = arg;
                String queryString = "SELECT *"
                        + " FROM employees " + "WHERE last_name like '"
                        + name + "%'";


                resultSet = statement.executeQuery(queryString);

                while (resultSet.next()) {
                    String employeeId = resultSet.getString("emp_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String ssn = resultSet.getString("ssn");
                    String dept = resultSet.getString("dept");
                    String room = resultSet.getString("room");
                    String phone = resultSet.getString("phone");

                    System.out.println(" Row from employees: " + employeeId + " "
                                + firstName + " " + lastName + " "
                                + ssn + " " + dept + " " + room + " " + phone);
                }



            } catch (ClassNotFoundException classNotFound) {
                classNotFound.printStackTrace();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (Exception exception) {
                System.err.println("General Error");
                exception.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }

                    if (statement != null) {
                        statement.close();
                    }

                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }



    /**
     *  The main program for the JDBCSelectWhereExample class
     *
     *@param  args  The command line arguments
     *
     *@since
     *
     */
    public static void main(String[] args) {

        JDBCInsertEmployee employees = new JDBCInsertEmployee();

        employees.runSample(args);

    }
}
