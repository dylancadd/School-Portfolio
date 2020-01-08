<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<c:import url="head.jsp"/>
	<c:import url="project4-add-form-styles.jsp"/>
	<body>
		<div id="wrap">
			<c:import url="project4-add-header.jsp"/>

			<c:import url="sidebar.jsp"/>

			<c:import url="project4-add-employee-content.jsp"/>
			<c:remove var="project4AddMessage" scope="session" />

			<c:import url="footer.jsp"/>
		</div>
	</body>
</html>
