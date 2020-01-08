package java112.employee;

import java.util.*;

/**
 *  Holds the getters and setters for each data associated with the search
 *
 *@author    djcadd
 */
public class Search {

    // Private instance variables
    private String searchType;
    private String searchTerm;
    private List<Employee> results = new ArrayList();
    private boolean foundEmployee = false;

    // Empty constructor
    public Search() {

    }

    // Add the employee object to the list
    public void addFoundEmployee(Employee employee) {
        results.add(employee);
    }

    // Getters for all of the instance variables
    public String getSearchType() {
        return searchType;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public List<Employee> getResults() {
        return results;
    }

    public boolean getFoundEmployee() {
        return foundEmployee;
    }

    // Setters for all of the instance variables
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public void setResults(List results) {
        this.results = results;
    }

    public void setFoundEmployee(boolean foundEmployee) {
        this.foundEmployee = foundEmployee;
    }
}
