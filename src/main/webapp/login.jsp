<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

<form action="/login.servlet" method="post">

<h2>Sign in</h2>
<ul>

    <li>Nick: <input name="signNick" type="text"></li>
    <li>Password: <input name="signPassword"></li>
</ul>
    <input type="submit" value="Submit">

<h2>If You Have An Account Log in</h2>
<ul>

    <li>Nick: <input name="logNick" type="text"></li>
    <li>Password: <input name="logPassword"></li>

</ul>
    <input type="submit" value="Submit">
</form>
</body>
</html>
