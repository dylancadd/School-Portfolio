    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="content">
    <div class="box">
        <c:choose>
            <c:when test="${search_emp.foundEmployee}">
                <table>
                    <tr>
                      <th>Employee ID</th>
                      <th>First Name</th>
                      <th>Last Name</th>
                      <th>Social Security #</th>
                      <th>Department</th>
                      <th>Room</th>
                      <th>Phone</th>
                    </tr>

                    <c:forEach var="employee" items="${search_emp.results}">
                      <tr>
                        <td>${employee.employeeId}</td>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.socialSecurity}</td>
                        <td>${employee.department}</td>
                        <td>${employee.room}</td>
                        <td>${employee.phone}</td>
                      </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <br><h1>No Results To Show</h1>

            </c:otherwise>
        </c:choose>
    </div>
</div>
