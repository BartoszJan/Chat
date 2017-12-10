<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="utf-8" %>
<html>
<body>

<%
    String error = request.getParameter("error");
    if (error != null && "".equals(error)) {
        out.println("Brak wiadomości");
    }

    String nick = "";
    for (Cookie cookie: request.getCookies()) {
        if ("nick-cookie".equals(cookie.getName())) {
            nick = cookie.getValue();
        }
    }
%>

<form action="/tweet.servlet" method="post">
    <ul>

        <li>Nick: <%=nick%></li>
        <li>Message: <textarea name="message"></textarea></li>

    </ul>
    <input type="submit" value="Submit">
</form>

</body>
</html>
