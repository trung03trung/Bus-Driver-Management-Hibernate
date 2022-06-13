package org.example.dao;

import org.example.entity.Route;
import org.example.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class RouteDAOImpl implements RouteDAO {
    @Override
    public List<Route> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<Route> routes=session.createQuery("from Route ").list();
            session.getTransaction().commit();
            return routes;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Route getOneById(int id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            Query<Route> query=session.createQuery("from Route where id=:r_id");
            query.setParameter("r_id",id);
            Route route=query.getSingleResult();
            session.getTransaction().commit();
            return route;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addNew(Route route) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(route);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean update(Route route) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(route);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Route route) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.delete(route);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }
        return false;
    }
}
