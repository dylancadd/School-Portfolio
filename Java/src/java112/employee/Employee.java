package java112.employee;

/**
 *  Holds the getters and setters for each data associated with the employee
 *
 *@author    djcadd
 */
public class Employee {

    // Private Instance variables
    private String employeeId;
    private String firstName;
    private String lastName;
    private String socialSecurity;
    private String department;
    private String room;
    private String phone;

    // Getters for all of the instance variables
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }

    public String getDepartment () {
        return department;
    }

    public String getRoom() {
        return room;
    }

    public String getPhone() {
        return phone;
    }

    // Setters for all of the instance variables
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurity(String socialSecurity) {
        this.socialSecurity = socialSecurity;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Employee {"
                + "\nempId: " + employeeId
                + "\nfirstName: " + firstName
                + "\nlastName: " + lastName
                + "\nsocialSecurity: " + socialSecurity
                + "\ndepartment: " + department
                + "\nroom: " + room
                + "\nphone: " + phone
                + "}";
    }
}
