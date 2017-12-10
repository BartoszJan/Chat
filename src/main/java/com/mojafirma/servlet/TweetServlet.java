package com.mojafirma.servlet;

import com.google.common.base.Strings;
import com.mojafirma.model.Tweet;
import com.mojafirma.model.User;
import com.mojafirma.model.dao.TweetDao;
import com.mojafirma.model.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tweetServlet", value = "/tweet.servlet")
public class TweetServlet extends HttpServlet {

    TweetDao tweetDao = new TweetDao();
    UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String message = (String) req.getParameter("message");
        String nick = "";

        for (Cookie cookie : req.getCookies()) {
            if ("nick-cookie".equals(cookie.getName())) {
                nick = cookie.getValue();
            }
        }

        if (Strings.isNullOrEmpty(message)) {
            resp.getWriter().println("Brak wiadomości!");
            resp.addHeader("erro", "not message");
            resp.sendRedirect("/publish.jsp?error");
        } else {
            User tweetUser = new User();
            for (int i = 0; i < userDao.getUsersList().size(); i++) {
                if (userDao.getUsersList().get(i).getNick().equals(nick)) {
                    tweetUser = userDao.getUsersList().get(i);
                }
            }
            Tweet tweet = new Tweet();
            tweet.setUser(tweetUser);
            tweet.setMessage(message);
            tweet.setTimestamp(System.currentTimeMillis());
            tweetDao.addTweet(tweet);

            resp.sendRedirect("/index.jsp");
        }
    }
}