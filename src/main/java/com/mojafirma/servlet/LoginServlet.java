package com.mojafirma.servlet;

import com.google.common.base.Strings;
import com.mojafirma.model.User;
import com.mojafirma.model.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/login.servlet")
public class LoginServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String signNick = (String) req.getParameter("signNick");
        String signPassword = (String) req.getParameter("signPassword");

        String logNick = (String) req.getParameter("logNick");
        String logPassword = (String) req.getParameter("logPassword");
        UserDao userDao = new UserDao();

        if (Strings.isNullOrEmpty(signNick) && Strings.isNullOrEmpty(signPassword)) {
            resp.getWriter().println("Empty nick or password!");
            resp.addHeader("erro", "not author");
            resp.sendRedirect("/publish.jsp?error");
        } else {
            User user = new User();
            user.setNick(signNick);
            user.setPassword(signPassword);
            userDao.addUser(user);
            Cookie cookie = new Cookie("nick-cookie", signNick);
            cookie.setMaxAge(3000);
            resp.addCookie(cookie);
            resp.sendRedirect("/index.jsp");
        }
    }
}
