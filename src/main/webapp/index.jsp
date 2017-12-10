<%@ page import="com.mojafirma.com.sdatwitter.service.MyTwitterService" %>
<%@ page import="com.mojafirma.com.sdatwitter.model.MyTweet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<p>
    <a href="publish.jsp">Publish tweet</a>
</p>
<%! MyTwitterService twitterService = MyTwitterService.getIntsace(); %>

<table border="1">
    <tr>
        <th width="100px">Author</th>
        <th width="200px">Date</th>
        <th width="300px">Message</th>
    </tr>

    <% for (MyTweet tweet: twitterService.getMyTweetsList()) {
            out.print("<tr>");
            out.print("<td>" + tweet.getAuthor() + "</td>");
            out.print("<td>" + tweet.getTimestamp() + "</td>");
            out.print("<td>" + tweet.getTweet() + "</td>");
            out.print("<tr>");

        }
    %>
</table>
<%--<%--%>
    <%--for (MyTweet tweet : twitterService.getMyTweetsList()) {--%>
        <%--out.println("Tweet Author: " + tweet.getAuthor() + "<br>");--%>
        <%--out.println("Tweet message: " + tweet.getTweet() + "<br>");--%>
        <%--out.println("Date: " + tweet.getTimestamp() + "<br>");--%>
    <%--}--%>
<%--%>--%>
</body>
</html>
