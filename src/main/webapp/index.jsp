<%@ page import="com.mojafirma.model.dao.TweetDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mojafirma.model.Tweet" %>
<%@ page import="java.util.ArrayList" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<p>
    <a href="publish.jsp">Publish tweet</a>
</p>
<%! TweetDao tweetDao = new TweetDao();
    List<Tweet> tweets = tweetDao.getTweetList();
%>

<table border="1">
    <tr>
        <th width="100px">Author</th>
        <th width="200px">Date</th>
        <th width="300px">Message</th>
    </tr>

    <% for (Tweet tweet : tweets) { %>
       <tr>
           <td><%= tweet.getUser().getNick() %> </td>
           <td><%= tweet.getTimestamp()%></td>
           <td><%= tweet.getMessage() %></td>
        </tr>
    <% } %>
</table>
</body>
</html>
