<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="Hello World" /><br>
<table>
<c:forEach var="item" items="${list}" >

<tr><td>${item.title}</td><td><c:out value="${item.contents}" /></td></tr>
</c:forEach>
</table>
