package com.mojafirma.model.dao;

import com.mojafirma.model.Tweet;
import com.mojafirma.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TweetDao {

    public void addTweet(Tweet tweet) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        session.save(tweet);

        session.getTransaction().commit();
        session.close();
    }

    public Tweet getTweet(int id) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        Tweet tweet = session.get(Tweet.class, id);
        session.getTransaction().commit();

        session.close();

        return tweet;
    }

    public List<Tweet> getTweetList() {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        List<Tweet> tweets = session.createQuery("FROM Tweet").list();
        session.getTransaction().commit();

        session.close();

        return tweets;
    }

    public void deleteTweet(int id) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        Tweet tweet = session.get(Tweet.class, id);
        session.delete(tweet);
        session.getTransaction().commit();

        session.close();
    }

    public void updateTweet(Tweet tweet) {
        Session session = HibernateUtil.getHibernateSession().getSessionFactory().openSession();

        session.beginTransaction();
        session.update(tweet);
        session.getTransaction().commit();

        session.close();
    }
}
