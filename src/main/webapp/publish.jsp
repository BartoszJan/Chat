<%@ page import="com.mojafirma.com.sdatwitter.servlet.PublishServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<body>

<%
    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.println("Brak autora lub/i wiadomości");
    }

    String author = " ";
    for (Cookie cookie: request.getCookies()) {
        if (PublishServlet.AUTHOR.equals(cookie.getName())) {
            author = cookie.getValue();
        }
    }
%>
<form action="/publish.servlet" method="post">
    <ul>

        <li>Author <input name="author" type="text" value=<%= author %> ></li>
        <li>Message: <textarea name="message"></textarea></li>

    </ul>
    <input type="submit" value="Submit">
</form>

</body>
</html>
