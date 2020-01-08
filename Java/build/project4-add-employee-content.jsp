<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="content">
    <div class="box">
        <c:choose>
            <c:when test="${empty project4AddMessage}">
            </c:when>
            <c:otherwise>
                <div class="container-message" style="padding: 1.5em">
                  <label id="message" style="padding-left: 15px">${project4AddMessage}</label>
                </div>
            </c:otherwise>
        </c:choose>

        <form action="/java112/add-employee" method="post">
            <div class="formcontainer">
                <div class="container">
                    <label for="firstName"><strong>First Name</strong></label>
                    <input type="text" name="firstName" maxlength="25" required />

                    <label for="lastName"><strong>Last Name</strong></label>
                    <input type="text" name="lastName" maxlength="30" required />

                    <label for="ssn"><strong>Social Security Number</strong></label>
                    <input type="text" name="ssn" maxlength="20" required />

                    <label for="dept"><strong>Department</strong></label>
                    <input type="text" name="dept" maxlength="10" required />

                    <label for="room"><strong>Room Number</strong></label>
                    <input type="text" name="room" maxlength="10" required />

                    <label for="phone"><strong>Phone Number</strong></label>
                    <input type="text" name="phone" maxlength="10" required />
                 </div>

                 <button type="submit"><strong>ADD EMPLOYEE</strong></button><br>

            </div>
         </form>
     </div>
 </div>
