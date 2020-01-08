package java112.employee;

import java.util.*;
import java.io.*;
import java.sql.*;

/**
 *  Does all of the JDBC work with the database
 *
 *@author    djcadd
 */
public class EmployeeDirectory {

    // Instance variables
    Properties properties = new Properties();

    // Empty constructor
    public EmployeeDirectory() {

    }

    /**
     * Assigns the properties whenever EmployeeDirectory is instantiated
     * @param properties Assigns the properties object to this properties variable
     */
    public EmployeeDirectory(Properties properties) {

        // Assign properties to this objects properties
        this();
        this.properties = properties;
    }

    // Establishes connection to the database and return the connection
    private Connection establishConnection() {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(properties.getProperty("connection.url"), properties.getProperty("connection.username"), properties.getProperty("connection.password"));
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }

        return connection;
    }

    /**
     * Add a new record to the employee table in the database.
     * @param fn    FirstName variable sent from the html form
     * @param ln    LastName variable sent from the html form
     * @param ssn   SocialSecurity variable sent from the html form
     * @param dept  Department variable sent from the html form
     * @param room  Room variable sent from the html form
     * @param phone Phone variable sent from the html form
     */
    public void addNewEmployee(String fn, String ln, String ssn, String dept, String room, String phone) {

        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName(properties.getProperty("connection.driver"));

            connection = establishConnection();

            statement = connection.createStatement();

            String firstNameArg = fn;
            String lastNameArg = ln;
            String snnArg = ssn;
            String deptArg = dept;
            String roomArg = room;
            String phoneArg = phone;

            String queryString = "INSERT INTO employees(first_name, last_name, ssn, dept, room, phone) VALUES"
                    + "('" + firstNameArg
                    + "', '" + lastNameArg
                    + "', '" + snnArg
                    + "', '" + deptArg
                    + "', '" + roomArg
                    + "', '" + phoneArg + "')";

            statement.executeUpdate(queryString);
            
        } catch (ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        } finally {
            try {
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
     * Calls correct method depending on the searchType
     * @param  searchTerm SearchTerm variable from the html form
     * @param  searchType SearchType variable from the html form
     * @return            Search object with the searchTerm and searchType
     */
    public Search searchEmployee(String searchTerm, String searchType) {

        // Creates a reference to the Search class and assigns the searchTerm and searchType
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        // Calls corresponding method for the searchType
        switch (searchType) {
            case "id":
                searchEmployeeById(search);
                break;
            case "firstName":
                searchEmployeeByFirstName(search);
                break;
            case "lastName":
                searchEmployeeByLastName(search);
                break;
        }

        return search;
    }

    /**
     * Searches the database for an employee based on EmployeeID
     * @param search Search object to grab the SearchTerm
     */
    private void searchEmployeeById(Search search) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(properties.getProperty("connection.driver"));

            String searchTerm = search.getSearchTerm();

            connection = establishConnection();

            statement = connection.createStatement();

            String queryString = "SELECT * FROM employees WHERE emp_id = " + searchTerm;

            resultSet = statement.executeQuery(queryString);

            while(resultSet.next()) {
                search.setFoundEmployee(true);
                Employee emp = new Employee();

                emp.setEmployeeId(resultSet.getString("emp_id"));
                emp.setFirstName(resultSet.getString("first_name"));
                emp.setLastName(resultSet.getString("last_name"));
                emp.setSocialSecurity(resultSet.getString("ssn"));
                emp.setDepartment(resultSet.getString("dept"));
                emp.setRoom(resultSet.getString("room"));
                emp.setPhone(resultSet.getString("phone"));

                search.addFoundEmployee(emp);
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
     * Searches the database for an employee based on LastName
     * @param search Search object to grab the SearchTerm
     */
    private void searchEmployeeByLastName(Search search) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(properties.getProperty("connection.driver"));

            String searchTerm = search.getSearchTerm();

            connection = establishConnection();

            statement = connection.createStatement();

            String queryString = "SELECT * FROM employees WHERE last_name LIKE '%" + searchTerm + "%'";

            resultSet = statement.executeQuery(queryString);

            while(resultSet.next()) {
                search.setFoundEmployee(true);
                Employee emp = new Employee();

                emp.setEmployeeId(resultSet.getString("emp_id"));
                emp.setFirstName(resultSet.getString("first_name"));
                emp.setLastName(resultSet.getString("last_name"));
                emp.setSocialSecurity(resultSet.getString("ssn"));
                emp.setDepartment(resultSet.getString("dept"));
                emp.setRoom(resultSet.getString("room"));
                emp.setPhone(resultSet.getString("phone"));

                search.addFoundEmployee(emp);
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
     * Searches the database for an employee based on FirstName
     * @param search Search object to grab the SearchTerm
     */
    private void searchEmployeeByFirstName(Search search) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(properties.getProperty("connection.driver"));

            String searchTerm = search.getSearchTerm();

            connection = establishConnection();

            statement = connection.createStatement();

            String queryString = "SELECT * FROM employees WHERE first_name LIKE '%" + searchTerm + "%'";

            resultSet = statement.executeQuery(queryString);

            while(resultSet.next()) {
                search.setFoundEmployee(true);
                Employee emp = new Employee();

                emp.setEmployeeId(resultSet.getString("emp_id"));
                emp.setFirstName(resultSet.getString("first_name"));
                emp.setLastName(resultSet.getString("last_name"));
                emp.setSocialSecurity(resultSet.getString("ssn"));
                emp.setDepartment(resultSet.getString("dept"));
                emp.setRoom(resultSet.getString("room"));
                emp.setPhone(resultSet.getString("phone"));

                search.addFoundEmployee(emp);
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
}
