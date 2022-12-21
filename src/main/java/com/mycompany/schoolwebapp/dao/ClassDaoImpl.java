/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.schoolwebapp.dao;

import com.mycompany.schoolwebapp.model.Classes;
import java.util.Collections;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClassDaoImpl implements ClassDao {

    @Autowired
    SessionFactory sessionFactory;

//    @Resource
//    EntityManager entityManager;
    @Override
    public List<Classes> getAllClasss() {
        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("Classes.findAll");
            return query.list();
        } catch (HibernateException e) {
            System.out.println(ClassDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public Classes getClassById(int classId) {

        try {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.getNamedQuery("Classes.findById");
            query.setParameter("classId", classId);
            return (Classes) query.uniqueResult();
        } catch (HibernateException e) {
            System.out.println(ClassDaoImpl.class.getName() + " - " + e.getMessage());
        }
        return null;
    }
}
