<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<h1>Spring Security Demo</h1>

<div style="margin-bottom: 1em">
    <a href="<c:url value="admin.do"/>">Admin Page</a>
</div>

<!-- this is a bit naff - you can simulate POST with Javascript, but I was too lazy to research -->
<form name='f' action="logout" method='POST'>
    <td><input name="submit" type="submit" value="logout"/></td>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
</body>
</html>