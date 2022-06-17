package org.example.dao;

import org.example.entity.Division;
import org.example.entity.DivisionDetail;
import org.example.entity.Driver;
import org.example.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DivisionDetailDAOImpl implements DivisionDetailDAO {
    @Override
    public List<DivisionDetail> getAll() {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            List<DivisionDetail> divisionDetails=session.createQuery("from DivisionDetail ").list();
            session.getTransaction().commit();
            return divisionDetails;
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
    public boolean addNew(DivisionDetail divisionDetail) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=null;
        try {
            tx=session.beginTransaction();
            session.save(divisionDetail);
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
