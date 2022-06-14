package org.example.dao;

import org.example.entity.Division;
import org.example.entity.DivisionDetail;
import org.example.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DivisionDAOImpl implements DivisionDAO{
    @Override
    public List<Division> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<Division> division=session.createQuery("from Division ").list();
            session.getTransaction().commit();
            return division;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean addNew(Division division) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(division);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Division division) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.update(division);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Division division) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.delete(division);
            session.getTransaction().commit();
            return true;
        }catch (HibernateException e){
            if(tx==null)
                tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return false;
    }
}
